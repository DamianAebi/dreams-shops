package com.damiansprojekt.dreamshops.repository;

import com.damiansprojekt.dreamshops.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
