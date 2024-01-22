package com.melsheikh.hotelreservation.models;

import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.models.types.RoomType;

public class Room implements IRoom {

    protected String roomNumber;
    protected Double price;
    protected RoomType roomType;

    public Room(String roomNumber, Double price, RoomType roomType) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");

        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getId() {
        return this.roomNumber;
    }

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Room)) return false;

        return ((Room) obj).roomNumber.equalsIgnoreCase(roomNumber);
    }

    @Override
    public int hashCode() {
        return roomNumber.toLowerCase().hashCode();
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
