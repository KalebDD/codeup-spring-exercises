package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    // Main page - show all the posts for the user
    @GetMapping("/posts/index")
    public String viewAllPosts(Model model) {
        List<Post> postList = new ArrayList<>();

        // Post Number 1
        Post post = new Post(1,"Post 1 Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        postList.add(post);

        // Post Number 2
        post = new Post(2, "Post 2 Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        postList.add(post);

        model.addAttribute("postList", postList);
        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String viewIndividualPost(Model model) {
        Post singlePost = new Post (3, "Post 3 Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        model.addAttribute("postTitle", singlePost.getTitle());
        model.addAttribute("postDescription", singlePost.getDescription());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost() {
        return "View the 'Create a Post form' and create a new post here.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "View the 'Create a Post form' and create a new post here.";
    }
}
