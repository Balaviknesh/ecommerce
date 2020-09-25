package com.egen.ecommerce.model;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class OrderPaymentDetails {

    @Id
    private String order_payment_id;
    private char order_payment_method;
    private Date order_payment_date;
    private String order_payment_confirmation_number;
    @OneToOne(cascade = CascadeType.ALL)
    private Address order_billing_address;
    public OrderPaymentDetails(){
        this.order_payment_id = UUID.randomUUID().toString();
    }

}
