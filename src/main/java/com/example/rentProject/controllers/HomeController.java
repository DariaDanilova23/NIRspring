package com.example.rentProject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.rentProject.models.TypeOfRenter;
import com.example.rentProject.services.TypeOfRenterServices;


@Controller
public class HomeController {
  private final TypeOfRenterServices typeOfRenterServices;

  public HomeController(TypeOfRenterServices typeOfRenterServices) {
    this.typeOfRenterServices = typeOfRenterServices;
}

   @GetMapping("/")
     public String getIndex(Model model){
        try{
          model.addAttribute("perem", "Какой-то текст из контроллера");
        } catch(Exception e){
          e.printStackTrace();
        }
        return "index";
     }

    @GetMapping("/renterType")
    public String yourPage(Model model) {
        List<TypeOfRenter> yourEntities = typeOfRenterServices.getAllTypesOfRenters();
        model.addAttribute("yourEntities", yourEntities);

        return "renterType";
    }
    
}
