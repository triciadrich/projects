package com.openshippinh.openshipping.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.openshippinh.openshipping.Models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
  List<Item> findAll(Sort sort);
  List<Item> findByUser_id(Long id);
  List<Item> findByStatus(String status);
  
  

  
}
