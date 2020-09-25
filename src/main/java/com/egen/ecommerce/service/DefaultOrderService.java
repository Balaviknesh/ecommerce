package com.egen.ecommerce.service;

import com.egen.ecommerce.exception.BadRequestException;
import com.egen.ecommerce.exception.NotFoundException;
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
            throw new NotFoundException("Order with the id:" + order_id + " doesn't exist.");

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
        if (!op_order.isPresent())
            throw new NotFoundException("Order with the id:" + order_id + " doesn't exist.");

        return op_order.orElse(null);
    }

    @Override
    public String cancelOrderByID(String order_id) {

        Optional<Order> order = orderRepository.findById(order_id);

        if (!order.isPresent())
            throw new NotFoundException("Order with the id:" + order_id + " doesn't exist.");

        Order updatedOrder = new Order();
        updatedOrder.setOrder_id(order_id);
        updatedOrder.setOrder_status('e');
        orderRepository.save(updatedOrder);


        return "Order Cancelled";
    }

    @Override
    public boolean createOrder(Order order) {
        if(order.getOrderDetails().isEmpty())
            throw new BadRequestException("Order doesnt have any items. Please add items to create order");
        if(order.getShipping_address() == null)
            throw new BadRequestException("Order doesnt have any items. Please add items to create order");

        orderRepository.save(order);
        return true;
    }

}
