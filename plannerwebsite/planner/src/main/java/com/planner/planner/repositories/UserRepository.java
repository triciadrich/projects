package com.planner.planner.repositories;
import java.util.List;

import com.planner.planner.models.user;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<user, Long> {
  List<user> findAll();
  user findByEmail(String email);
}
