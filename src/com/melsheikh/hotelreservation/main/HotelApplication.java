package com.melsheikh.hotelreservation.main;

import com.melsheikh.hotelreservation.views.MainMenu;

public class HotelApplication {
    public static void main(String[] args) {
        IoCContainer container = new IoCContainer();
        container.getInstance(MainMenu.class).displayMenu();
    }
}
