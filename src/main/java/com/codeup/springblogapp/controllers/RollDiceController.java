package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "rollDice";
    }

    @GetMapping("/roll-dice/{num}")
    public String test(@PathVariable int num, Model model) {

        int diceRoll = (int) (1 + (Math.random() * 6));

        String response = "You rolled a: " + num + "<br>"
                + "The dice rolled a: " + diceRoll + "<br>";

        if (num == diceRoll) {
            response += "It's a match!";
        } else {
            response += "Sorry!";
        }

        model.addAttribute("response", response);
        return "rollDice";
    }

}
