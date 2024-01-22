package com.melsheikh.hotelreservation.views;

import com.melsheikh.hotelreservation.api.AdminResource;
import com.melsheikh.hotelreservation.constants.Constants;
import com.melsheikh.hotelreservation.models.types.RoomType;
import com.melsheikh.hotelreservation.views.base.AbstractMenu;
import com.melsheikh.hotelreservation.views.base.MenuItem;

import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class AdminMenu extends AbstractMenu {

    private AdminResource adminResource;

    protected AdminMenu(Scanner scanner, Map<Integer, MenuItem> menuOptions) {
        super(scanner, menuOptions);
    }

    public AdminMenu(Scanner scanner, AdminResource adminResource) {
        this(scanner,
                Map.of(
                        1, new MenuItem("See all customers", null),
                        2, new MenuItem("See all rooms", null),
                        3, new MenuItem("See all reservations", null),
                        4, new MenuItem("Add a room", null),
                        5, new MenuItem("Back to main menu", null)
                ));

        this.scanner = scanner;
        this.adminResource = adminResource;

        menuOptions.get(1).setAction(this::seeAllCustomers);
        menuOptions.get(2).setAction(this::seeAllRooms);
        menuOptions.get(3).setAction(this::seeAllReservations);
        menuOptions.get(4).setAction(this::addARoom);
        postConstruct();
    }

    @Override
    public void displayMenu() {
        out.println("Admin Menu");
        super.displayMenu();
    }

    private void seeAllCustomers() {
        out.println("Customer Accounts List:");
        adminResource.getAllCustomers().forEach(out::println);
    }

    private void seeAllRooms() {
        out.println("Rooms List:");
        adminResource.getAllRooms().forEach(out::println);
    }

    private void seeAllReservations() {
        out.println("Reservations List:");
        adminResource.displayAllReservations();
    }

    private void addARoom() {
        out.println("Add New Room");
        out.println("-".repeat(Constants.CONSOLE_WIDTH));
        String roomNo = enterText("Enter room number: ");
        double price = enterDouble("Enter price per night: ");
        RoomType roomType = enterConstant("Enter room type (1 = 'Single Bed', 2 = 'Double Bed'): ");
        adminResource.addRoom(roomNo, price, String.valueOf(roomType.ordinal()));
        if (enterYesOrNo("Would you like to add another new room? (Y/N): ")) addARoom();
    }

    public void setMainMenuNavigation(Runnable navigation) {
        menuOptions.get(5).setAction(navigation);
    }

}
