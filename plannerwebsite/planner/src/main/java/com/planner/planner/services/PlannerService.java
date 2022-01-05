package com.planner.planner.services;

import java.util.List;

import com.planner.planner.models.planner;
import com.planner.planner.models.user;
import com.planner.planner.repositories.PlannerRepository;

import org.springframework.stereotype.Service;

@Service
public class PlannerService {
  private final PlannerRepository planRepo;

   public PlannerService(PlannerRepository planRepo){
     this.planRepo = planRepo;
   }

  public List<planner> getAllPlanners(){
    return this.planRepo.findAll();
  }

  public planner getOnePlanner(Long id){
    return this.planRepo.findById(id).orElse(null);
  }

  public planner createPlanner(planner planner){
    return this.planRepo.save(planner);
  }

  public planner editPlanner(planner planner){
    return this.planRepo.save(planner);
  }

  public String deletePlanner(Long id){
    this.planRepo.deleteById(id);
    return "planner has been deleted";
  }
  
  public void addUsertoPlanner(user user, planner planner){
    planner.setUser(user);
    this.planRepo.save(planner);
  }

  public List<planner> findBy(Long id){
    return this.planRepo.findByUser_id(id);
  }






}
