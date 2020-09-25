package com.egen.ecommerce.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Address {

    @Id
    private String address_id;
    private String address_line1;
    private String address_line2;
    private int Zip;
    private String State;
    private String City;
    public Address(){
        this.address_id = UUID.randomUUID().toString();
    }

}
