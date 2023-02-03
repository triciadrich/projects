package com.openshippinh.openshipping.services;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.config.Encoder;
import com.openshippinh.openshipping.repositories.RoleRepository;
import com.openshippinh.openshipping.repositories.UserRepository;

@Service
public class UserService {
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private Encoder encoder;

  
  public UserService(UserRepository userRepository, RoleRepository
  roleRepository, Encoder encoder) {
  this.userRepository = userRepository;
  this.roleRepository = roleRepository;
  this.encoder = encoder;

  }

  // 1
  public void saveWithUserRole(User user) {
  
    user.setPassword  (encoder.bCryptPasswordEncoder().encode(user.getPassword()));
    user.setRoles(roleRepository.findByName("ROLE_USER"));
    userRepository.save(user);
  }

  // 2
  public void saveUserWithAdminRole(User user) {
    user.setPassword(encoder.bCryptPasswordEncoder().encode(user.getPassword()));
    user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    userRepository.save(user);
  }

  // 3
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public User findUserById(Long id){
    Optional<User> u = userRepository.findById(id);
    if(u.isPresent()){
      return u.get();
    }else{
      return null;
    }
  }

  public UserRepository getUserRepository() {
    return userRepository;
  }

  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public RoleRepository getRoleRepository() {
    return roleRepository;
  }

  public void setRoleRepository(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }


}
