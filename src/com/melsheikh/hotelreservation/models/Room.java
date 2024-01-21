package com.melsheikh.hotelreservation.models;

import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.models.types.RoomType;

public class Room implements IRoom {

    protected String roomNumber;
    protected Double price;
    protected RoomType roomType;

    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public boolean isFree() {
        return this.price == 0.0;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }
}
