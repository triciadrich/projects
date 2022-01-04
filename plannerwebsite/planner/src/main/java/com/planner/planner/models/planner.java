package com.planner.planner.models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;



import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Date;

@Entity
@Table(name="planner")

public class planner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull
  private String name;
  @NotNull
  private String type;
  private Integer notes;
  @NotNull
  private Double price;
  @NotNull
  private String dimensions;
  @NotNull
  private String brand;
  @NotNull
  private String img;
  @NotNull
  private String link;
  @NotNull
  private String desc;
  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="user_id")
}

