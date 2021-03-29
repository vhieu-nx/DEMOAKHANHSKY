package com.codegym.socialNetwork.controller;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Post;
import com.codegym.socialNetwork.service.post.IPostService;
import com.codegym.socialNetwork.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired
    IUserService userService;

    @Autowired
    IPostService postService;

    @ModelAttribute()
    public AppUser currentUser(){
        return userService.getCurrentUser();
    }

    @PostMapping("/posts/create")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        String context = post.getContext();
        Post post1 = new Post();
        post1.setContext(context);
        post1.setStatus(post.getStatus());
        post1.setAppUser(currentUser());
        postService.save(post1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Iterable<Post>> listPost(@PathVariable Long id){
        AppUser appUser = userService.findById(id).get();
        Iterable<Post> posts = postService.findAllByUser(appUser);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
}
