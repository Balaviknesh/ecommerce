package com.egen.ecommerce.service;


import com.egen.ecommerce.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    String getOrderStatus(String order_id);
    Order getOrderByID(String order_id);
    String cancelOrderByID(String order_id);
    boolean createOrder(Order order);


}
