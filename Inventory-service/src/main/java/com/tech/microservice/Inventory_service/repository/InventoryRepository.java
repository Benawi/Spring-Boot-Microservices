package com.tech.microservice.Inventory_service.repository;

import com.tech.microservice.Inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String sku_code, int quantity);


}
