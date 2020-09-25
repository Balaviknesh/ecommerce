package com.egen.ecommerce.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class OrderDetails {

    @Id
    private String order_details_id;
    private String order_item_name;
    private double order_item_qty;
    private double order_subtotal;
    private double order_tax;
    private double order_shipping_charges;
    private double order_total;
    public OrderDetails(){
        this.order_details_id = UUID.randomUUID().toString();
    }

}
