package com.damiansprojekt.dreamshops.repository;

import com.damiansprojekt.dreamshops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Name(String name);

    Long countByBrandAndName(String brand, String name);
}
