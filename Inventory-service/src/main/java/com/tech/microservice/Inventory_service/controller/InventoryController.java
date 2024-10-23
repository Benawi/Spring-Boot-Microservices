package com.tech.microservice.Inventory_service.controller;

import com.tech.microservice.Inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String sku_code, @RequestParam Integer quantity){
       return inventoryService.isInStock(sku_code,quantity);
    }
}
