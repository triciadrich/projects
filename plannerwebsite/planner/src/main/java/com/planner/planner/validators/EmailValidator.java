package com.planner.planner.validators;



import com.planner.planner.models.user;
import com.planner.planner.services.UserService;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator {
  public UserService uService;
  @Override
  public boolean supports(Class<?> clazz){
    return user.class.equals(clazz);

  }
  @Override
  public void validate(Object target, Errors error){
    user user = (user) target;
    if(uService.findByEmail(user.getEmail()) != null){
      error.reject("email exists", "email already exists");
    }
  }
}
