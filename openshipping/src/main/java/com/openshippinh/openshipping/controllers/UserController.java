package com.openshippinh.openshipping.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.services.UserService;

@Controller
public class UserController {
  private UserService userService;
    
  public UserController(UserService userService) {
      this.userService = userService;
  }

  @RequestMapping("/registration")
  public String registerForm(@Valid @ModelAttribute("user") User user){

  return "registerForm";
  }

  @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "registrationPage.jsp";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
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
