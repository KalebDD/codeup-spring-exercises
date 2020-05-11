package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/{math}/{num1}/{text}/{num2}")
    @ResponseBody
    public String math(@PathVariable String math, @PathVariable double num1, @PathVariable String text, @PathVariable double num2) {
        double output = 0;

        switch (math) {
            case "add": output = num1 + num2;
            break;
            case "subtract": output = num1 - num2;
            break;
            case "multiply": output = num1 * num2;
            break;
            case "divide": output = num1 / num2;
            break;
        }
        return "<h1>Your equation equals: " + output +"</h1>";
    }
}
