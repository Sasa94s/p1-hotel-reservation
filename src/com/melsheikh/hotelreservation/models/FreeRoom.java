package com.melsheikh.hotelreservation.models;

import com.melsheikh.hotelreservation.models.types.RoomType;

public class FreeRoom extends Room implements Entity<String> {

    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, price, roomType);
        this.price = 0.0;
    }

    @Override
    public String getId() {
        return this.roomNumber;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
