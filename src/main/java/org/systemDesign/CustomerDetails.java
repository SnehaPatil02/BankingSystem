package org.systemDesign;

import java.io.Serializable;
import java.util.UUID;

public class CustomerDetails implements Serializable{
    private String customerId;
    private String name;
    transient String address;


    
    public CustomerDetails() {
    }

    public CustomerDetails(String name,String address) {
        this.customerId = UUID.randomUUID().toString();
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAddress() {
        return address;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "CustomerDetails{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address +
                '}';
    }
}
