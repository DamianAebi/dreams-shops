package com.damiansprojekt.dreamshops.service.order;

import com.damiansprojekt.dreamshops.model.Order;
import com.damiansprojekt.dreamshops.request.AddOrderRequest;

import java.util.List;

public interface IOrderService {
    Order placeOrder(AddOrderRequest request);
    List<Order> getUserOrders(Long userId);
}
