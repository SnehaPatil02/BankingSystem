package org.systemDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerDetails {
    String customerId;
    String name;
    String address;


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

    public String toString() {
        return "CustomerDetails{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address +
                '}';
    }
}
