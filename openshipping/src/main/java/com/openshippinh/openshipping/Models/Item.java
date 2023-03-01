package com.openshippinh.openshipping.Models;

import java.util.Date;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String type;
  private String deliverTo;
  private String pickUpFrom;
  private String status;
  private String notes;
  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
  public Item() {
  }


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getDeliverTo() {
    return deliverTo;
  }
  public void setDeliverTo(String deliverTo) {
    this.deliverTo = deliverTo;
  }
  public String getPickUpFrom() {
    return pickUpFrom;
  }
  public void setPickUpFrom(String pickUpFrom) {
    this.pickUpFrom = pickUpFrom;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
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
  

  @PrePersist
  protected void onCreate(){
      this.createdAt = new Date();
  }
  @PreUpdate
  protected void onUpdate(){
      this.updatedAt = new Date();
  }


  public User getUser() {
    return user;
  }


  public void setUser(User user) {
    this.user = user;
  }
  
  @Override
  public String toString(){
    return "Item{id=" + id + ", type='" + type + "', pick up from='" + pickUpFrom + "', deliver to=" + deliverTo + "}";
  }
}
