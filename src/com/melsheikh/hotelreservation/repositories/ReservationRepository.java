package com.melsheikh.hotelreservation.repositories;

import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.repositories.base.AbstractRepository;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class ReservationRepository extends AbstractRepository<String, Reservation> {
    private static ReservationRepository instance;

    private ReservationRepository() {
        super();
    }

    public static ReservationRepository getInstance() {
        if (instance == null) {
            instance = new ReservationRepository();
        }

        return instance;
    }

    public boolean isRoomReserved(String roomId) {
        return items.containsKey(roomId);
    }

    public Set<IRoom> findReservedRooms(Date checkInDate, Date checkOutDate) {
        return items.values()
                .stream()
                .filter(reservation ->
                        !checkInDate.after(reservation.getCheckOutDate()) &&
                                !checkOutDate.before(reservation.getCheckInDate()))
                .map(Reservation::getRoom)
                .collect(Collectors.toSet());
    }

}
