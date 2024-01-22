package com.melsheikh.hotelreservation.api;

import com.melsheikh.hotelreservation.helpers.EnumHelper;
import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.FreeRoom;
import com.melsheikh.hotelreservation.models.Room;
import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.models.types.RoomType;
import com.melsheikh.hotelreservation.services.CustomerService;
import com.melsheikh.hotelreservation.services.ReservationService;

import java.util.Collection;

public class AdminResource {

    private final CustomerService customerService;
    private final ReservationService reservationService;

    public AdminResource(CustomerService customerService, ReservationService reservationService) {
        this.customerService = customerService;
        this.reservationService = reservationService;
    }

    public Customer getCustomer(String email) {
        try {
            return customerService.getCustomer(email);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid email address - Cause: " + e.getMessage(), e);
        }
    }

    public void addRoom(String roomNumber, Double price, String roomType) {
        RoomType type = EnumHelper.getEnumConstant(RoomType.class, Integer.parseInt(roomType) - 1);
        IRoom room;
        if (price == 0.0) {
            room = new FreeRoom(roomNumber, price, type);
        } else {
            room = new Room(roomNumber, price, type);
        }
        reservationService.addRoom(room);
    }

    public Collection<IRoom> getAllRooms() {
        Collection<IRoom> rooms = reservationService.findAllRooms();
        if (rooms.isEmpty()) throw new IllegalStateException("No rooms found");

        return rooms;
    }

    public Collection<Customer> getAllCustomers() {
        Collection<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty()) throw new IllegalStateException("No customers found");

        return customers;
    }

    public void displayAllReservations() {
        reservationService.printAllReservation();
    }
}
