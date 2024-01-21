package com.melsheikh.hotelreservation.api;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.types.IRoom;

import java.util.Collection;

public class AdminResource {

    private static AdminResource instance = null;

    private AdminResource() {
    }

    public static AdminResource getInstance() {
        if (instance == null) {
            instance = new AdminResource();
        }
        return instance;
    }

    public Customer getCustomer(String email) {
        // TODO - implement AdminResource.getCustomer
        return null;
    }

    public void addRoom(String roomNumber, Double price, String roomType) {
        // TODO - implement AdminResource.addRoom
    }

    public Collection<IRoom> getAllRooms() {
        // TODO - implement AdminResource.getAllRooms
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        // TODO - implement AdminResource.getAllCustomers
        return null;
    }

    public void displayAllReservations() {
        // TODO - implement AdminResource.displayAllReservations
    }
}
