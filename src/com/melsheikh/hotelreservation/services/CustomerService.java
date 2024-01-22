package com.melsheikh.hotelreservation.services;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.repositories.CustomerRepository;

import java.util.Collection;

import static java.lang.System.out;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(String email, String firstName, String lastName) {
        if (customerRepository.findById(email).isPresent()) {
            throw new IllegalArgumentException("Customer already exists");
        }

        Customer customer = new Customer(firstName, lastName, email);
        customerRepository.save(customer);
        out.printf("Added new %s %s successfully%n", customer.getClass().getSimpleName(), customer.getId());

        return customer;
    }

    public Customer getCustomer(String customerEmail) {
        return customerRepository.findById(customerEmail)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    public Collection<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void printAllCustomers() {
        getAllCustomers().forEach(out::println);
    }
}
