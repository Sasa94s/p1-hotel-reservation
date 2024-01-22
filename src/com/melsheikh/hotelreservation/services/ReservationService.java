package com.melsheikh.hotelreservation.services;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.repositories.ReservationRepository;
import com.melsheikh.hotelreservation.repositories.RoomRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public void addRoom(IRoom room) {
        roomRepository.save(room);
        out.printf("Added new %s %s successfully%n", room.getClass().getSimpleName(), room.getId());
    }

    public IRoom getARoom(String roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        if (reservationRepository.findReservedRooms(checkInDate, checkOutDate).contains(room)) {
            throw new IllegalArgumentException("Room is already reserved");
        }

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationRepository.save(reservation);
        out.printf("Added new %s %s successfully%n", reservation.getClass().getSimpleName(), reservation.getId());

        return reservation;
    }

    public Collection<IRoom> findAllRooms() {
        return roomRepository.findAll();
    }

    public void printAllRooms() {
        findAllRooms().forEach(out::println);
    }

    public IRoom findRoom(String roomNo) {
        return roomRepository.findById(roomNo)
                .orElseThrow(() -> new IllegalArgumentException("Room number is not existing"));
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Set<IRoom> reservedRooms = this.reservationRepository.findReservedRooms(checkInDate, checkOutDate);

        return this.roomRepository.findAll()
                .stream()
                .filter(room -> !reservedRooms.contains(room))
                .toList();
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        return reservationRepository.findAll()
                .stream()
                .filter(reservation -> reservation.getCustomer().equals(customer))
                .toList();
    }

    public void printAllReservation() {
        List<Reservation> reservations = reservationRepository.findAll();
        if (reservations.isEmpty()) out.println("No reservations found");
        else reservations.forEach(out::println);
    }
}
