package com.codeup.springblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //dictates this is a controller in MVC
public class HelloController {
    // @RequestMapping(path = "/hello", method = RequestMethod.GET)
    // Above and below are the same thing - above is more explicit, below is shorthand
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/target-ad/{id}")
    @ResponseBody
    public String showAd(@PathVariable long id){
        return "Your target ad id is: " + id;
    }
}
