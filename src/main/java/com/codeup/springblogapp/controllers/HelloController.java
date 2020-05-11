package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //dictates this is a controller in MVC
public class HelloController {
    // @RequestMapping(path = "/hello", method = RequestMethod.GET)
    // Above and below are the same thing - above is more explicit, below is shorthand
    @GetMapping("/hello")
    public String showHello() {
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/target-ad/{id}")
    @ResponseBody
    public String showAd(@PathVariable long id){
        return "Your target ad id is: " + id;
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

    @GetMapping("/welcome")
    public String showWelcome() {
        return "welcome";
    }
}
