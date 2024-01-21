package com.melsheikh.hotelreservation.services;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.types.IRoom;

import java.util.Collection;
import java.util.Date;

public class ReservationService {

    private static ReservationService reservationService = null;

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(IRoom room) {
        // TODO - implement ReservationService.addRoom
        throw new UnsupportedOperationException();
    }

    public IRoom getARoom(String roomId) {
        // TODO - implement ReservationService.getARoom
        throw new UnsupportedOperationException();
    }

    public Reservation reserveARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        // TODO - implement ReservationService.reserveARoom
        throw new UnsupportedOperationException();
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        // TODO - implement ReservationService.findRooms
        throw new UnsupportedOperationException();
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        // TODO - implement ReservationService.getCustomersReservation
        throw new UnsupportedOperationException();
    }

    public void printAllReservation() {
        // TODO - implement ReservationService.printAllReservation
        throw new UnsupportedOperationException();
    }
}
