package com.planner.planner.controllers;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  private ArrayList<planner> compare = new ArrayList<planner>();
  private final PlannerService plannerService;
  private final UserService uService;

  public HomeController(UserService uService, PlannerService plannerService, EmailValidator emailValid) {
    this.plannerService = plannerService;
    this.uService = uService;

  }

  @RequestMapping("/")
  public String index(@ModelAttribute("planner") planner planner, Model model) {
    List<planner> planners = this.plannerService.getAllPlanners();
    model.addAttribute("planners", planners);
    return "index.jsp";
  }

  @GetMapping("/loginreg")
  public String loginreg(@ModelAttribute("user") user user, Model model) {
    return "loginreg.jsp";
  }

  @PostMapping("/registration")
  public String registerUser(@Valid @ModelAttribute("user") user user, BindingResult result, HttpSession session) {
    // emailValid.validate(user, result);
    if (result.hasErrors()) {
      return "loginreg.jsp";
    }
    user u = uService.registerUser(user);
    session.setAttribute("userId", u.getId());
    return "redirect:/";
  }

  @PostMapping("/login")
  public String loginUser(@ModelAttribute("user") user user, @RequestParam("email") String email,
      @RequestParam("password") String password, Model model, HttpSession session) {
    String error = "Invalid";
    boolean isAuthenticated = uService.authenticateUser(email, password);
    if (isAuthenticated) {
      user u = uService.findByEmail(email);
      session.setAttribute("userId", u.getId());
      return "redirect:/";
    } else {
      model.addAttribute("error", error);
      return "loginreg.jsp";
    }
  }

  @GetMapping("/account")
  public String accountPage(@ModelAttribute("user") user user, @ModelAttribute("planner") planner planner,
      HttpSession session, Model model) {
    if (session.getAttribute("userId") == null) {
      return "loginreg.jsp";
    }
    Long userId = (Long) session.getAttribute("userId");
    user u = uService.findUserById(userId);
    model.addAttribute("user", u);
    return "account.jsp";
  }

  @PostMapping("/addPlanner")
  public String addPlanner(@Valid @ModelAttribute("planner") planner planner, BindingResult result,
      HttpSession session) {
    if (result.hasErrors()) {
      return "redirect:/account";
    }
    Long userId = (Long) session.getAttribute("userId");
    user u = uService.findUserById(userId);
    this.plannerService.createPlanner(planner);
    this.plannerService.addUsertoPlanner(u, planner);
    return "redirect:/";
  }

  @GetMapping("/details/{id}")
  public String plannerDetail(@PathVariable("id") Long id, @ModelAttribute("user") user user, Model model,
      HttpSession session) {
    if (session.getAttribute("userId") == null) {
      model.addAttribute("planner", this.plannerService.getOnePlanner(id));
      return "detail.jsp";
    } else {

      model.addAttribute("user", this.uService.findUserById((Long) session.getAttribute("userId")));
      model.addAttribute("planner", this.plannerService.getOnePlanner(id));
      return "detail.jsp";
    }
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable("id") Long id, @ModelAttribute("planner") planner planner, Model model) {
    model.addAttribute("planner", this.plannerService.getOnePlanner(id));
    return "edit.jsp";

  }

  @PostMapping("/edit/{id}")
  public String editPlanner(@Valid @ModelAttribute("planner") planner planner, BindingResult result,
      @PathVariable("id") Long id, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("planner", this.plannerService.getOnePlanner(id));
      return "edit.jsp";
    }
    this.plannerService.editPlanner(planner);
    return "/details/{id}";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable("id") Long id, Model model) {
    this.plannerService.deletePlanner(id);
    return "redirect:/";
  }

  @PostMapping("/compare/{id}")
  public String compare(@PathVariable("id") Long id) {
    
    compare.add(this.plannerService.getOnePlanner(id));

    return "redirect:/details/{id}";

  }

  @GetMapping("/compare")
  public String comparePage(Model model) {
    model.addAttribute("compare", compare);

    return "compare.jsp";
  }

  @GetMapping("/removecom/{id}")
  public String removeCom(@PathVariable("id") Long id, @ModelAttribute("planner") planner planner) {
    System.out.println(id);

    for (int i = 0; i < compare.size(); i++) {
      planner p = compare.get(i);
      if (p.getId() == id) {

        compare.remove(i);
      }
    }

    return "redirect:/compare";
  }

}
