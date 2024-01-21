package com.melsheikh.hotelreservation.views;

import com.melsheikh.hotelreservation.views.base.AbstractMenu;
import com.melsheikh.hotelreservation.views.base.MenuItem;

import java.util.Map;

public class AdminMenu extends AbstractMenu {

    protected AdminMenu(Map<Integer, MenuItem> menuOptions) {
        super(menuOptions);
    }

    public AdminMenu() {
        this(Map.of(
                1, new MenuItem("See all customers", null),
                2, new MenuItem("See all rooms", null),
                3, new MenuItem("See all reservations", null),
                4, new MenuItem("Add a room", null),
                5, new MenuItem("Back to main menu", null)
        ));

        menuOptions.get(1).setAction(this::seeAllCustomers);
        menuOptions.get(2).setAction(this::seeAllRooms);
        menuOptions.get(3).setAction(this::seeAllReservations);
        menuOptions.get(4).setAction(this::addARoom);
        menuOptions.get(5).setAction(this::backToMainMenu);
    }

    private void seeAllCustomers() {
        System.out.println("seeAllCustomers");
    }

    private void seeAllRooms() {
        System.out.println("seeAllRooms");
    }

    private void seeAllReservations() {
        System.out.println("seeAllReservations");
    }

    private void addARoom() {
        System.out.println("addARoom");
    }

    private void backToMainMenu() {
        System.out.println("backToMainMenu");
    }

}
