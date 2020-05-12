package com.codeup.springblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRollDice() {
        return "rollDice";
    }

    @GetMapping("/roll-dice/{num}")
    public String checkRollDice(@PathVariable int num, Model model) {

        int diceRoll = (int) (1 + (Math.random() * 6));

        String response = "You rolled a: " + num + ". "
                + "The dice rolled a: " + diceRoll + ". ";

        if (num == diceRoll) {
            response += "It's a match!";
        } else {
            response += "Sorry!";
        }

        model.addAttribute("response", response);
        return "rollDice";
    }

}
