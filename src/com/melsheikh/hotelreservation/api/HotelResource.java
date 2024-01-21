package com.melsheikh.hotelreservation.api;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.types.IRoom;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private static HotelResource instance = null;

    private HotelResource() {
    }

    public static HotelResource getInstance() {
        if (instance == null) {
            instance = new HotelResource();
        }
        return instance;
    }

    public Customer getCustomer(String email) {
        // TODO - implement HotelResource.getCustomer
        return null;
    }

    public void createACustomer(String email, String firstName, String lastName) {
        // TODO - implement HotelResource.createACustomer
    }

    public IRoom getRoom(String roomNumber) {
        // TODO - implement HotelResource.getRoom
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        // TODO - implement HotelResource.bookARoom
        return null;
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        // TODO - implement HotelResource.getCustomersReservations
        return null;
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        // TODO - implement HotelResource.findARoom
        return null;
    }
}
