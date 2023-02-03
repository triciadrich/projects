package com.openshippinh.openshipping.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openshippinh.openshipping.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
  

  
}
