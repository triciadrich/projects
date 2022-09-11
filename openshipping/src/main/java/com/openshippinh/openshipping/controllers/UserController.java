package com.openshippinh.openshipping.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openshippinh.openshipping.Models.User;

@Controller
public class UserController {
  @RequestMapping("/registration")
  public String registerForm(@Valid @ModelAttribute("user") User user){

  return "registerForm";
  }

  @RequestMapping("/login")
  public String login(@Valid @ModelAttribute("user") User user){
    return"loginPage";
  }

  @RequestMapping("/dashboard")
  public String dashboard(){
    return"dashboard";
  }
}
