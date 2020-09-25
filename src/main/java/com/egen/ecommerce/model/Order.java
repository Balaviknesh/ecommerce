package com.egen.ecommerce.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "cus_order")

public class Order {

    @Id
    private String order_id;
    private String customer_id;
    private char order_status;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderPaymentDetails> orderPaymentDetails;
    @OneToOne(cascade = CascadeType.ALL)
    private Address shipping_address;
    public Order(){
        this.order_id = UUID.randomUUID().toString();
    }

}