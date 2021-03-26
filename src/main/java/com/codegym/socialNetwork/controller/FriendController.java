package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Friend;
import com.codegym.socialNetwork.repository.FriendRepo;

import com.codegym.socialNetwork.repository.FriendRequestRepo;
import com.codegym.socialNetwork.repository.UserRepo;
import com.codegym.socialNetwork.security.SpringUser;
import com.codegym.socialNetwork.service.friend.IFriendService;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    private FriendRequestRepo friendRequestRepo;

    @Autowired
    private UserRepo userRepo;
    @GetMapping("list")
    public ModelAndView showAllFriends() {
        ModelAndView modelAndView = new ModelAndView("friend/list");
        Iterable<Friend> friends = friendService.findAll();
        modelAndView.addObject("friends", friends);
        return modelAndView;
    }

//    @GetMapping("/friends")
//    public ModelAndView FriendPage(@AuthenticationPrincipal SpringUser springUser, ModelMap modelMap) {
//        List<Friend> friends = FriendRepo.findAllByToIdOrFromId(springUser.getUser().getId(), springUser.getUser().getId());
//        List<AppUser> userFriends = new ArrayList<>();
//        for (Friend friend : friends) {
//            if (friend.getFrom().getId() == springUser.getUser().getId()) {
//                userFriends.add(friend.getTo());
//            } else if (friend.getTo().getId() == springUser.getUser().getId()) {
//                userFriends.add(friend.getFrom());
//            }
//        }
//        modelMap.addAttribute("user", springUser.getUser());
////        modelMap.addAttribute("users", userRepo.findAllByIdIsNotLike(springUser.getUser().getId()));
////        modelMap.addAttribute("requests", friendRequestRepo.findAllByToId(springUser.getUser().getId()));
//        modelMap.addAttribute("friends", userFriends);
//        return "userPage";
//    }
//
//    @GetMapping("/add")
//    public ModelAndView showInsertForm() {
//        ModelAndView modelAndView = new ModelAndView("friend/add");
//        modelAndView.addObject("friend", new Friend());
//        return modelAndView;
//    }
//
//    @PostMapping("/add")
//    public ModelAndView AddFriend(@ModelAttribute("friend") Friend friend) {
//        friendService.save(friend);
//        ModelAndView modelAndView = new ModelAndView("friend/add");
//        modelAndView.addObject("message", "Friend created successfully");
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Optional<Friend> friend = friendService.findById(id);
//        if (friend.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("friend/delete");
//            modelAndView.addObject("friend", friend);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public void deleteFriend(@ModelAttribute("friend") Friend friend) {
//        friendService.remove(friend.getId());
//    }
//
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
