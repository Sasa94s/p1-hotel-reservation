package com.melsheikh.hotelreservation.views;

import com.melsheikh.hotelreservation.views.base.AbstractMenu;
import com.melsheikh.hotelreservation.views.base.MenuItem;

import java.util.Map;
import java.util.function.Consumer;

import static java.lang.System.out;

public class MainMenu extends AbstractMenu {

    protected MainMenu(Map<Integer, MenuItem> menuOptions) {
        super(menuOptions);
    }

    public MainMenu() {
        this(Map.of(
                1, new MenuItem("Find and reserve a room", null),
                2, new MenuItem("See my reservations", null),
                3, new MenuItem("Create an account", null),
                4, new MenuItem("Admin", null),
                5, new MenuItem("Exit", null)
        ));

        menuOptions.get(1).setAction(this::findAndReserveARoom);
        menuOptions.get(2).setAction(this::seeMyReservations);
        menuOptions.get(3).setAction(this::createAnAccount);
        menuOptions.get(4).setAction(this::admin);
        menuOptions.get(5).setAction(this::exit);
    }


    private void findAndReserveARoom() {
        out.println("findAndReserveARoom");
    }

    private void seeMyReservations() {
        out.println("seeMyReservations");
    }

    private void createAnAccount() {
        out.println("createAnAccount");
    }

    private void admin() {
        out.println("admin");
    }

    private void exit() {
        out.println("exit");
    }


}
