package com.egen.ecommerce.controller;

import com.egen.ecommerce.model.Order;
import com.egen.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class OrderController {

    public OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/test")
    public String testing(){
        return "API works Successfully";
    }


    @GetMapping("/getOrderStatus")
    public String order_status(@RequestParam String order_id){
        return orderService.getOrderStatus(order_id);
    }

    @GetMapping("/getOrderByID")
    public Order order(@RequestParam String order_id){
        return orderService.getOrderByID(order_id);
    }

    @PutMapping("/cancelOrderByID")
    public String cancel_order(@RequestParam String order_id){
        return orderService.cancelOrderByID(order_id);
    }

    @PostMapping("/createOrder")
    public boolean order_create(@RequestBody Order order){ return orderService.createOrder(order); }

}
