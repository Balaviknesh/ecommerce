package com.egen.ecommerce.service;

import com.egen.ecommerce.model.Order;
import com.egen.ecommerce.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultOrderService implements OrderService{

    public OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository){

        this.orderRepository = orderRepository;

    }

    @Override
    public String getOrderStatus(String order_id) {

        Optional<Order> order = orderRepository.findById(order_id);


        if (!order.isPresent())
            return "Record Not Found";

        Order order_out = order.get();

        char status = order_out.getOrder_status();


        switch (status){

            case 'a' :

                return "Created";

            case 'b' :

                return  "Processing";


            case 'c' :

                return "Shipping";


            case 'd' :

                return "delivered";


            case 'e' :

                return "Canceled";


            default: return "Something went wrong";

        }


    }

    @Override
    public Order getOrderByID(String order_id) {

        Optional<Order> op_order = orderRepository.findById(order_id);
        return op_order.orElse(null);
    }

    @Override
    public String cancelOrderByID(String order_id) {

        Optional<Order> order = orderRepository.findById(order_id);

        if (!order.isPresent())
            return "Record Not Found";

        Order updatedOrder = new Order();
        updatedOrder.setOrder_id(order_id);
        updatedOrder.setOrder_status('e');
        orderRepository.save(updatedOrder);


        return "Order Cancelled";
    }

    @Override
    public boolean createOrder(Order order) {
        orderRepository.save(order);
        return true;
    }


}
