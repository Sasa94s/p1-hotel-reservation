package com.melsheikh.hotelreservation.api;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.services.CustomerService;
import com.melsheikh.hotelreservation.services.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    private CustomerService customerService;
    private ReservationService reservationService;

    public HotelResource(CustomerService customerService, ReservationService reservationService) {
        this.customerService = customerService;
        this.reservationService = reservationService;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public Customer createACustomer(String email, String firstName, String lastName) {
        try {
            customerService.getCustomer(email);
            throw new IllegalArgumentException("Customer account email already exists.");
        } catch (Exception e) {
            return customerService.addCustomer(email, firstName, lastName);
        }
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.findRoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = customerService.getCustomer(customerEmail);

        return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        Customer customer = customerService.getCustomer(customerEmail);

        return reservationService.getCustomersReservation(customer);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

}
