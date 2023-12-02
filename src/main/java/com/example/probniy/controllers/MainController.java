package com.example.probniy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // контролер відповідає за обробку всіх переходів на сайті
public class MainController {
    @GetMapping("/") // анотація, яка оброблює URL-адресу
    public String index(Model model) {
        return "home";
    }
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/out")
    public String logout(Model model) {
        return "out";
    }
}