package com.damiansprojekt.dreamshops.service.order;

import com.damiansprojekt.dreamshops.enums.OrderStatus;
import com.damiansprojekt.dreamshops.exception.ResourceNotFoundException;
import com.damiansprojekt.dreamshops.model.Order;
import com.damiansprojekt.dreamshops.model.OrderItem;
import com.damiansprojekt.dreamshops.model.Product;
import com.damiansprojekt.dreamshops.repository.OrderRepository;
import com.damiansprojekt.dreamshops.repository.ProductRepository;
import com.damiansprojekt.dreamshops.request.AddOrderRequest;
import com.damiansprojekt.dreamshops.service.user.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final IUserService userService;

    @Transactional
    @Override
    public Order placeOrder(AddOrderRequest request) {
        Order order = createOrder(request);
        List<OrderItem> orderItemList = createOrderItems(request.productId, order);
        order.setOrderItems(new HashSet<>(orderItemList));
        return orderRepository.save(order);
    }

    public Order createOrder(AddOrderRequest request) {
        Order order = new Order();
        order.setUser(userService.getUserById(request.userId));
        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDate.now());
        return order;
    }

    public List<OrderItem> createOrderItems(Long productId, Order order) {
        var optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            return List.of();
        }

        Product product = optionalProduct.get();

        return List.of(new OrderItem(
                order,
                product,
                1,
                product.getPrice()
        ));
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return orderRepository.findAll();
    }
}
