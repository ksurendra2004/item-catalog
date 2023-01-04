package com.itemcatalog.controller;

import com.itemcatalog.entity.ItemEntity;
import com.itemcatalog.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem/{item}")
    public ItemEntity addItem(@RequestParam String itemName) throws Exception {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setName(itemName);
        return itemService.addItem(itemEntity);
    }

    @PutMapping("/updateItem/{id}")
    public String updateItem(@RequestBody ItemEntity itemEntity) throws Exception {
        //itemEntity.setId(id);
        return itemService.updateItem(itemEntity);
    }

    @GetMapping("/items")
    public Collection<ItemEntity> getItems() throws Exception {
        return itemService.getItems();
    }

    @GetMapping("/item/{id}")
    public Optional<ItemEntity> getItem(@PathVariable Long id) throws Exception {
        return itemService.getItem(id);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable Long id) throws Exception {
        itemService.deleteItem(id);
        return "Item id "+id+" deleted successfully";
    }
}
