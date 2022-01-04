package com.planner.planner.models;




import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import antlr.collections.List;

import javax.validation.constraints.Email;

@Entity
@Table(name="user")
public class user {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  private String userName;
  @Column(unique = true)
  @Email(message="Email must be valid")
  private String email;
  @Size(min=5, message = "Password must be greater than 5 characters")
  private String password;
  @Transient
  private String passwordConfirmation;
  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  
  private List<planner> planners;
    public List<Planner> getPlanners(){
      return planners;
    }

  public user() {
  }
}
