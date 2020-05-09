package org.springphony.jokesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springphony.jokesapp.service.JokeService;

@Controller
public class JokesController {

    private JokeService jokeService;

    @Autowired // no need to add autowired as spring framework implicitly does this
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJokes(Model model){
        model.addAttribute("joke", jokeService.getJokes());
        return "chucknorris";
    }
}
