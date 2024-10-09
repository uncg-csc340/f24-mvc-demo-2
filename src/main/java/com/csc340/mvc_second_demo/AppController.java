package com.csc340.mvc_second_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "/index"})
    public String home() {
        return "redirect:/goals/all";
    }

}
