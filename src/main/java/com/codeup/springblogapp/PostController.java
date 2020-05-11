package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postText() {
        return "posts index page.";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postTextAndId(@PathVariable int id) {
        return "View an individual post with id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPost() {
        return "View the 'Create a Post form' and create a new post here.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "View the 'Create a Post form' and create a new post here.";
    }
}
