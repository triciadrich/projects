package com.openshippinh.openshipping.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openshippinh.openshipping.Models.Item;
import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.repositories.ItemRepository;

@Service
public class ItemService {
  private final ItemRepository iRepo;

  public ItemService(ItemRepository iRepo) {
    this.iRepo = iRepo;
  }

  public List<Item> allItems(){
    return iRepo.findAll();
  }
  
  public Item createItem(Item i){
    return iRepo.save(i);
  }

  public Item getItem(Long id){
    return this.iRepo.findById(id).orElse(null);
  }

  public List<Item> findByUser(Long id){
    return this.iRepo.findByUser_id(id);
  }

  public void addUserToItem(User user, Item item){
    item.setUser(user);
    this.iRepo.save(item);  
  }
}
