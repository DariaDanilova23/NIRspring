package com.example.rentProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {
   @GetMapping("/")
     public String getIndex(Model model){
        try{
          model.addAttribute("perem", "Какой-то текст из контроллера");
        } catch(Exception e){
          e.printStackTrace();
        }
        return "index";
     }
    
}
