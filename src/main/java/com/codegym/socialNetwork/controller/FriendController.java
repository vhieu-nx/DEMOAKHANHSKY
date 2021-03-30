package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Friend;
import com.codegym.socialNetwork.repository.FriendRepo;

import com.codegym.socialNetwork.repository.UserRepo;
import com.codegym.socialNetwork.service.friend.FriendService;
import com.codegym.socialNetwork.service.friend.IFriendService;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("friends")
public class FriendController {

    @Autowired
    private IFriendService friendService;

    @Autowired
    private IUserService userService;

    @Autowired
    private FriendRepo friendRepo;

    @Autowired
    private UserRepo userRepo;

    @ModelAttribute("currentUser")
    private AppUser user() {
        return userService.getCurrentUser();
    }


    @GetMapping("list")
    public ModelAndView showAllFriends() {
        AppUser user = userService.getCurrentUser();
        ModelAndView modelAndView = new ModelAndView("friend/list");
        List<AppUser> friends = friendService.getListFriend(user.getId());
        modelAndView.addObject("friends", friends);
        return modelAndView;
    }

    //    @GetMapping("/delete/{id}")
//    public ModelAndView getRemoveFriend(@PathVariable(name = "id") long id) {
//        Optional<Friend> friendDelete = friendService.findById(id);
//        ModelAndView modelAndView;
//        if(friendDelete.isPresent()){
//            modelAndView = new ModelAndView("friend/delete");
//            modelAndView.addObject("friend", friendDelete.get());
//            return modelAndView;
//        }else{
//            modelAndView = new ModelAndView("404");
//            return modelAndView;
//        }
//
//    }
    @DeleteMapping("/delete/{id}")
    public ModelAndView RemoveFriend(@PathVariable(name = "id") long id) {
        friendService.remove(id);
        return new ModelAndView("redirect:/list");
    }
//    @GetMapping("/detail/{id}")
//    public ModelAndView detailFriend(@PathVariable Long id) {
//        Optional<Friend> friend = friendService.findById(id);
//        if (friend.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("friend/detail");
//            modelAndView.addObject("friend", friend);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error");
//            return modelAndView;
//        }
////    }

}
