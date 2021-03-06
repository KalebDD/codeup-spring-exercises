package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import com.codeup.springblogapp.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    // Email injection
    // Repo injection
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    // Main - show all the posts for the website ==========================
    @GetMapping("/posts")
    public String viewAllPosts(@ModelAttribute User user, Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{category}")
    @ResponseBody
    public List<Post> filteredPosts (@PathVariable String category) {
      return (List<Post>) postDao.findAllByCategory(category);
    }

    // Create - new post ==========================
    // No HTML @ this URL
    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        // Spring security methods to get currently logged-in user object
        // More details
        // https://docs.spring.io/spring-security/site/docs/5.1.6.RELEASE/reference/html/overall-architecture.html
        // https://stackoverflow.com/questions/45461091/spring-mvc-getting-user-id-from-logged-user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/profile";
    }

    // Edit - allow user to edit posts ==========================
    // No HTML @ this URL
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        // Spring security methods to get currently logged-in user object
        // More details
        // https://docs.spring.io/spring-security/site/docs/5.1.6.RELEASE/reference/html/overall-architecture.html
        // https://stackoverflow.com/questions/45461091/spring-mvc-getting-user-id-from-logged-user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        postDao.save(post);
        return "redirect:/profile";
    }

    // Delete - allow user to delete posts ==========================
    // No HTML @ this URL
    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam(name = "deletePostId") long id) {
        postDao.deleteById(id);
        return "redirect:/profile";
    }

    // View - single post
//    @GetMapping("/posts/show")
//    public String viewIndividualPost(Model model) {
//        Post singlePost = new Post("Post 3 Title", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
//
//        model.addAttribute("postTitle", singlePost.getTitle());
//        model.addAttribute("postDescription", singlePost.getDescription());
//        return "posts/show";
//    }
}
