package com.planner.planner.services;

import java.util.Optional;

import com.planner.planner.models.user;
import com.planner.planner.repositories.UserRepository;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository uRepo;

  public UserService(UserRepository uRepo){
    this.uRepo = uRepo;
  }

  public user registerUser(user user){
    String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    user.setPassword(hashed);
    return uRepo.save(user);
  }

  public user findByEmail(String email){
    return uRepo.findByEmail(email);
  }

  public user findUserById(Long id){
    Optional<user> u = uRepo.findById(id);
      if(u.isPresent()){
        return u.get();
      }else {
        return null;
      }
  }
   
  public boolean authenticateUser(String email,String password){
    user user = uRepo.findByEmail(email);

    if(user == null){
      return false;
    }else{
      if (BCrypt.checkpw(password, user.getPassword())){
        return true;
      }else{
        return false;
      }
    }
  }
}