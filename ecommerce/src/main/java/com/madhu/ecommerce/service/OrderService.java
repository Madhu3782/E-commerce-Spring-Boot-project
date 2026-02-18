package com.madhu.ecommerce.service;

import com.madhu.ecommerce.entity.*;
import com.madhu.ecommerce.repository.OrderItemRepository;
import com.madhu.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Transactional
    public Order placeOrder(User user) {
        List<CartItem> cartItems = cartService.getCartItems(user);
        if (cartItems.isEmpty()) return null;

        Double total = cartService.getTotalPrice(user);
        Order order = Order.builder()
                .user(user)
                .totalAmount(total)
                .orderDate(LocalDateTime.now())
                .status("PENDING")
                .items(new ArrayList<>())
                .build();

        Order savedOrder = orderRepository.save(order);

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = OrderItem.builder()
                    .order(savedOrder)
                    .product(cartItem.getProduct())
                    .price(cartItem.getProduct().getPrice())
                    .quantity(cartItem.getQuantity())
                    .build();
            savedOrder.getItems().add(orderItem);
        }

        cartService.clearCart(user);
        return orderRepository.save(savedOrder);
    }

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUserOrderByOrderDateDesc(user);
    }
}
