package com.openshippinh.openshipping.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openshippinh.openshipping.Models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
  
  
}
