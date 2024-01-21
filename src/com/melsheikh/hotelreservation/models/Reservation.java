package com.melsheikh.hotelreservation.models;

import com.melsheikh.hotelreservation.models.types.IRoom;

import java.util.Date;

public class Reservation implements Entity<String> {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        if (customer == null || room == null || checkInDate == null || checkOutDate == null) {
            throw new IllegalArgumentException("Invalid reservation");
        }

        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String getId() {
        return String.format("%s_%s", this.customer.getId(), this.room.getId());
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
