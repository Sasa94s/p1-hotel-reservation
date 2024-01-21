package com.melsheikh.hotelreservation.models;

public class FreeRoom extends Room {

    public FreeRoom() {
        super();
        this.price = 0.0;
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
