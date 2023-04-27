package com.example.igonan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hellworld {

    @RequestMapping("/hello")
    public String hello(Model model) {
       // model.addAttribute("name", "Hell World!");
       // model.addAttribute("sibal", "sibal");
        return "mango";
    }


}

