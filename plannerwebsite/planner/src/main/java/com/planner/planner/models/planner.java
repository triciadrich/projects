package com.planner.planner.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.Date;

@Entity
@Table(name = "planners")
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
  @JoinColumn(name = "user_id")
  private user user;

  public planner() {
  }

  public user getUser() {
  return user;
  }

  public void setUser(user user) {
  this.user = user;
  }

  public planner(@NotNull String name, @NotNull String type, Integer notes,
  @NotNull Double price,
  @NotNull String dimensions, @NotNull String brand, @NotNull String img,
  @NotNull String link,
  @NotNull String desc) {
  this.name = name;
  this.type = type;
  this.notes = notes;
  this.price = price;
  this.dimensions = dimensions;
  this.brand = brand;
  this.img = img;
  this.link = link;
  this.desc = desc;
  }

  @PrePersist
  protected void onCreate() {
  this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
  this.updatedAt = new Date();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
  return type;
  }

  public void setType(String type) {
  this.type = type;
  }

  public Integer getNotes() {
  return notes;
  }

  public void setNotes(Integer notes) {
  this.notes = notes;
  }

  public Double getPrice() {
  return price;
  }

  public void setPrice(Double price) {
  this.price = price;
  }

  public String getDimensions() {
  return dimensions;
  }

  public void setDimensions(String dimensions) {
  this.dimensions = dimensions;
  }

  public String getBrand() {
  return brand;
  }

  public void setBrand(String brand) {
  this.brand = brand;
  }

  public String getImg() {
  return img;
  }

  public void setImg(String img) {
  this.img = img;
  }

  public String getLink() {
  return link;
  }

  public void setLink(String link) {
  this.link = link;
  }

  public String getDesc() {
  return desc;
  }

  public void setDesc(String desc) {
  this.desc = desc;
  }

  public Date getCreatedAt() {
  return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
  this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
  return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
  this.updatedAt = updatedAt;
  }
}
