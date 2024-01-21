package com.melsheikh.hotelreservation.main;

import com.melsheikh.hotelreservation.models.Customer;

import static java.lang.System.*;

public class Driver {
    public static void main(String[] args) {
        addValidCustomer();
//        addInvalidCustomer();
    }

    private static void addValidCustomer() {
        Customer customer = new Customer("Mostafa", "ElSheikh", "mosta@peaq.com");
        out.println(customer);
    }

    private static void addInvalidCustomer() {
        Customer customer = new Customer("first", "second", "email");
        out.println(customer);
    }
}
