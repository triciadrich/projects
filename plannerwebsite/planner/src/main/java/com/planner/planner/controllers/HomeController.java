package com.planner.planner.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.planner.planner.models.planner;
import com.planner.planner.models.user;
import com.planner.planner.services.PlannerService;
import com.planner.planner.services.UserService;
import com.planner.planner.validators.EmailValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
  private final PlannerService plannerService;
  private final UserService uService;
  private final EmailValidator emailValid;
  

  public HomeController(UserService uService, PlannerService plannerService, EmailValidator emailValid){
    this.plannerService = plannerService;
    this.uService = uService;
    this.emailValid = emailValid;
  }

  @RequestMapping("/")
  public String index(){
    
    return "index.jsp";
  }

  @GetMapping("/loginreg")
  public String loginreg(@ModelAttribute("user") user user, Model model){
    return "loginreg.jsp"; 
  }

  @PostMapping("/registration")
  public String registerUser(@Valid @ModelAttribute("user") user user, BindingResult result, HttpSession session) {
    // emailValid.validate(user, result);
    if(result.hasErrors()) {
      return"loginreg.jsp";
    }
    user u = uService.registerUser(user);
      session.setAttribute("userId", u.getId());
      return "redirect:/";
}

@PostMapping("/login")
  public String loginUser(@ModelAttribute("user")user user,@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
   String error ="Invalid"; 
  boolean isAuthenticated = uService.authenticateUser(email, password);
      if(isAuthenticated) {
        user u = uService.findByEmail(email);
        session.setAttribute("userId", u.getId());
        return "redirect:/";
      } else {
        model.addAttribute("error", error);
        return "loginreg.jsp";
      }
}

@GetMapping("/account")
public String accountPage(@ModelAttribute("user") user user,@ModelAttribute("planner")planner planner, HttpSession session, Model model){
  Long userId =(Long) session.getAttribute("userId");
  user u = uService.findUserById(userId);
  model.addAttribute("user", u);
  return "account.jsp";
}

@PostMapping("/addPlanner")
public String addPlanner(@Valid @ModelAttribute("planner") planner planner, BindingResult result, HttpSession session){
  if (result.hasErrors()){
    return "redirect:/account";
  }
  Long userId = (Long) session.getAttribute("userId");
  user u = uService.findUserById(userId);
  this.plannerService.createPlanner(planner);
  this.plannerService.addUsertoPlanner(u, planner);
  return "redirect:/";
}
 
}
