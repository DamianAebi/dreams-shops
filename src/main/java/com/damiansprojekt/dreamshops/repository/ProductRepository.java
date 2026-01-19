package com.damiansprojekt.dreamshops.repository;

import com.damiansprojekt.dreamshops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
