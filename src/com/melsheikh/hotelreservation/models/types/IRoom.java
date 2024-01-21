package com.melsheikh.hotelreservation.models.types;

import com.melsheikh.hotelreservation.models.Entity;

public interface IRoom extends Entity<String> {
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isFree();
}
