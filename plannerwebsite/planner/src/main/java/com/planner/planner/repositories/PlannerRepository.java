package com.planner.planner.repositories;
import java.util.List;

import com.planner.planner.models.planner;


import org.springframework.data.repository.CrudRepository;

public interface PlannerRepository extends CrudRepository<planner, Long>
{
  List<planner> findAll();
  List<planner> findByUser_id(Long id);
  
}
