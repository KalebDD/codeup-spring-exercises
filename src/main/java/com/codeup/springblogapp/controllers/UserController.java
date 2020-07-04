package com.codeup.springblogapp.controllers;

import com.codeup.springblogapp.model.Post;
import com.codeup.springblogapp.model.User;
import com.codeup.springblogapp.repositories.PostRepository;
import com.codeup.springblogapp.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private PasswordEncoder passwordEncoder;
    private final PostRepository postDao;
    private final UserRepository users;

    public UserController(PostRepository postDao, UserRepository users, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.postDao = postDao;
        this.users = users;
    }

    // No HTML @ this URL
    // Takes register form, hashes password, redirects back to main
    @PostMapping("/users/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/posts";
    }

    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long id = user.getId();
        model.addAttribute("post", new Post());
        model.addAttribute("allPosts", postDao.findAllByOwner_Id(id));
        return "users/profile";
    }
}