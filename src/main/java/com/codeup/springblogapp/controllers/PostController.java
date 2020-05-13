package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    // constructor for controller - gain access to Dao
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    // Main page - show all the posts for the user
    @GetMapping("/posts/index")
    public String viewAllPosts(Model model) {

        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @PostMapping("/posts/delete")
    public String viewAllPosts(@RequestParam(name = "delete") long id) {

        postDao.deleteById(id);
       return "redirect:/posts/index";
    }

    @GetMapping("/posts/show")
    public String viewIndividualPost(Model model) {
        Post singlePost = new Post("Post 3 Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        model.addAttribute("postTitle", singlePost.getTitle());
        model.addAttribute("postDescription", singlePost.getDescription());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam(name = "title") String title,
                             @RequestParam(name = "description") String description) {

        Post createPost = new Post(title, description);
        postDao.save(createPost);

        return "posts/create";
    }
}
