package com.melsheikh.hotelreservation.repositories;

import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.repositories.base.AbstractRepository;

public class RoomRepository extends AbstractRepository<String, IRoom> {
    private static RoomRepository instance;

    private RoomRepository() {
        super();
    }

    public static RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }

        return instance;
    }

}
