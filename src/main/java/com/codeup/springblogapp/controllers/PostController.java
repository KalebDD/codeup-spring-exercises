package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    // Access to all necessary repos
    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    // Main - show all the posts for the user
    @GetMapping("/posts/index")
    public String viewAllPosts(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    // Create - new post
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.getOne(1L);
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts/index";
    }

    // Edit - allow user to edit posts
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        User user = userDao.getOne(1L);
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/posts/index";
    }

    // Delete - allow user to delete posts
    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "deletePostId") long id) {
        postDao.deleteById(id);
        return "redirect:/posts/index";
    }

    // View - single post
    @GetMapping("/posts/show")
    public String viewIndividualPost(Model model) {
        Post singlePost = new Post("Post 3 Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        model.addAttribute("postTitle", singlePost.getTitle());
        model.addAttribute("postDescription", singlePost.getDescription());
        return "posts/show";
    }
}
