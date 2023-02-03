package com.openshippinh.openshipping.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.openshippinh.openshipping.Models.Item;
import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.services.ItemService;
import com.openshippinh.openshipping.services.UserService;
@Controller
public class ItemController {
  private final ItemService itemService;
  private final UserService userService;

  public ItemController(UserService userService, ItemService itemService){
    this.userService = userService;
    this.itemService = itemService;
  }

  // @RequestMapping("/dashboard")
  //   public String index(@ModelAttribute("Item") Item item, Model model){
  //     List<Item> items = this.itemService.allItems();
  //     model.addAttribute("items", items);
  //     return "dashboard";


  //   }

  @PostMapping("/addItem")
    public String addItem(@Valid @ModelAttribute("Item") Item item, BindingResult result, HttpSession session){
      if (result.hasErrors()){
          return "redirect:/dashboard";
      }
      String username = (String) session.getAttribute("username");
      User u = userService.findByUsername(username);
      this.itemService.createItem(item);
      this.itemService.addUserToItem(u, item);
      return "redirect:/dashboard";
      
    }
}
