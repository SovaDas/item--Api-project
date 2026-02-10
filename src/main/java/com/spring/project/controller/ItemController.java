package com.spring.project.controller;
import com.spring.project.model.Item;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/items")
    public class ItemController {

        private List<Item> itemList = new ArrayList<>();

        // Add new item
        @PostMapping
        public String addItem(@Valid @RequestBody Item item) {
            itemList.add(item);
            return "Item added successfully!";
        }

        // Get item by ID
        @GetMapping("/{id}")
        public Item getItemById(@PathVariable Integer id) {

            for (Item item : itemList) {
                if (item.getId().equals(id)) {
                    return item;
                }
            }

            throw new RuntimeException("Item not found with id: " + id);
        }
    }

