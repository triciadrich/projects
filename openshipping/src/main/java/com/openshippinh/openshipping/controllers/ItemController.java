package com.openshippinh.openshipping.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.openshippinh.openshipping.Models.Item;
import com.openshippinh.openshipping.Models.User;
import com.openshippinh.openshipping.services.EmailService;
import com.openshippinh.openshipping.services.ItemService;
import com.openshippinh.openshipping.services.UserService;


@Controller
public class ItemController {
  private final ItemService itemService;
  private final UserService userService;

  @Autowired
  private EmailService emailService;

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
      emailService.sendEmail("triciadrich@gmail.com", "New Item added to open shipping items", "Open Shipping items" +item.toString());
      return "redirect:/dashboard";
      
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @ModelAttribute("Item") Item item, Model model){
      model.addAttribute("item", this.itemService.getItem(id));
      return "edititem";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@Valid @ModelAttribute("Item") Item item, BindingResult result,@PathVariable("id") Long id, Model model){
      if(result.hasErrors()){
        model.addAttribute("item", this.itemService.getItem(id));
        return "redirect:/edititem";
      }
      this.itemService.editItem(item);
      emailService.sendEmail("triciadrich@gmail.com", "An opren shipping item has been changed", item.toString());

      return "redirect:/dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id, Model model,@ModelAttribute("Item") Item item){
      this.itemService.deleteItem(id);
      emailService.sendEmail("triciadrich@gmail.com", "An open shipping item has been deleted", 
      item.toString());
      return "redirect:/dashboard";
    }
}
