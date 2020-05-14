package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

    // @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    // Above and below are the same thing - above is more explicit, below is shorthand
    @GetMapping("/welcome")
    public String showWelcome() {
        return "codeup/welcome";
    }


    @GetMapping("/hello")
    public String showHello() {
        return "codeup/hello";
    }
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "codeup/hello";
    }


    @GetMapping("/join")
    public String showJoinForm() {
        return "codeup/join";
    }
    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "codeup/join";
    }
}
