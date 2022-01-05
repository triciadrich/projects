package com.planner.planner.controllers;

import java.util.List;

import com.planner.planner.models.planner;
import com.planner.planner.services.PlannerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
  private final PlannerService plannerService;
  public HomeController(PlannerService plannerService){
    this.plannerService = plannerService;
  }

  @RequestMapping("/")
  public String index(){
  
    return "index.jsp";
  }
}
