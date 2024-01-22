package com.melsheikh.hotelreservation.repositories;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.repositories.base.AbstractRepository;

public class CustomerRepository extends AbstractRepository<String, Customer> {
    private static CustomerRepository instance;

    private CustomerRepository() {
        super();
    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }

        return instance;
    }

}
