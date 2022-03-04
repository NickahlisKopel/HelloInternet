package com.careerdevs.hellointernet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;



@RestController
public class RootController {
    static Random rand = new Random();

    @GetMapping("/")
    private static String rootRoute(){
        return "You requested the root route";
    }

    @GetMapping("/random")
    private static int random(){
        return rand.nextInt(100);
    }

    @GetMapping("/joke")
    private static String joke(){
        String[] jokes = {"What's the best thing about Switzerland? I don't know, but the flag is a big plus.","I invented a new word! Plagiarism!","Did you hear about the mathematician who’s afraid of negative numbers? He’ll stop at nothing to avoid them.","Why do we tell actors to 'break a leg?' Because every play has a cast."};
        return jokes[rand.nextInt(jokes.length)];
    }
}
