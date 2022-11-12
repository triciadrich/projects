package com.openshippinh.openshipping.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.repositories.RoleRepository;
import com.openshippinh.openshipping.repositories.UserRepository;

@Service
public class UserService {
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  
  public UserService(UserRepository userRepository, RoleRepository
  roleRepository) {
  this.userRepository = userRepository;
  this.roleRepository = roleRepository;

  }

  // 1
  public void saveWithUserRole(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setRoles(roleRepository.findByName("ROLE_USER"));
    userRepository.save(user);
  }

  // 2
  public void saveUserWithAdminRole(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    userRepository.save(user);
  }

  // 3
  public User findByUsername(String username) {
    return userRepository.findByUsername(username);
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

  public BCryptPasswordEncoder getbCryptPasswordEncoder() {
    return bCryptPasswordEncoder;
  }

  public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }
}
