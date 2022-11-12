package com.openshippinh.openshipping.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.services.UserService;

@Controller
public class UserController {
  @Autowired
  private UserService userService;
  
  

  @RequestMapping("/registration")
  public String registerForm(@Valid @ModelAttribute("user") User user) {

    return "registerForm";
  }

  @PostMapping("/registration")
  public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
      HttpSession session) {
    if (result.hasErrors()) {
      return "registrationPage.jsp";
    }
    userService.saveWithUserRole(user);
    return "redirect:/login";
  }

  @RequestMapping("/login")
  public String login(@RequestParam(value ="error", required=false)String error,@RequestParam(value ="logout", required= false) String logout,@Valid @ModelAttribute("user") User user, Model model) {
    if(error != null){
      model.addAttribute("errorMessage", "Invalid credentials, Try again.");
    }
    if(logout != null){
      model.addAttribute("logoutMessage", "Logout succesful");
    }
    return "loginPage";
  }

  @RequestMapping(value = {"/","/dashboard"})
  public String dashboard(Principal principal, Model model) {
    String username = principal.getName();
    model.addAttribute("currentUser", userService.findByUsername(username));
    return "dashboard";
  }
}
