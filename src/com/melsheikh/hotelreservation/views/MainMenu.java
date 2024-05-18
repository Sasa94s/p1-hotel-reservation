package com.melsheikh.hotelreservation.views;

import com.melsheikh.hotelreservation.api.HotelResource;
import com.melsheikh.hotelreservation.constants.Constants;
import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.types.IRoom;
import com.melsheikh.hotelreservation.views.base.AbstractMenu;
import com.melsheikh.hotelreservation.views.base.MenuItem;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class MainMenu extends AbstractMenu {

    private HotelResource hotelResource;

    protected MainMenu(Scanner scanner, Map<Integer, MenuItem> menuOptions) {
        super(scanner, menuOptions);
    }


    public MainMenu(Scanner scanner, HotelResource hotelResource) {
        this(scanner,
                Map.of(
                        1, new MenuItem("Find and reserve a room", null),
                        2, new MenuItem("See my reservations", null),
                        3, new MenuItem("Create an account", null),
                        4, new MenuItem("Admin", null),
                        5, new MenuItem("Exit", null)
                ));

        this.hotelResource = hotelResource;

        menuOptions.get(1).setAction(this::findAndReserveARoom);
        menuOptions.get(2).setAction(this::seeMyReservations);
        menuOptions.get(3).setAction(this::createAnAccount);
        menuOptions.get(5).setAction(this::exit);
        postConstruct();
    }

    @Override
    public void displayMenu() {
        out.println("Welcome to the Hotel Reservation Application");
        out.println("-".repeat(Constants.CONSOLE_WIDTH));
        out.println("Main Menu");
        super.displayMenu();
    }

    private IRoom enterExistingRoomNo(String s) {
        String roomNo = enterText(s);
        try {
            return hotelResource.getRoom(roomNo);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
        }

        return enterExistingRoomNo(s);
    }

    private Customer enterExistingEmail(String s) {
        String email = enterText(s);
        try {
            return hotelResource.getCustomer(email);
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        return enterExistingEmail(s);
    }

    private void findAndReserveARoom() {
        out.println("Find and reserve a room:-");
        Date now = stripTime(new Date());
        Date checkInDate = enterDate("Enter CheckIn Date mm/dd/yyyy (e.g. 02/01/2020): ");
        Date checkOutDate = enterDate("Enter CheckOut Date mm/dd/yyyy (e.g. 2/21/2020): ");
        if (!checkOutDate.after(checkInDate) || checkInDate.before(now)) {
            out.println("CheckOut is not after CheckIn date or CheckIn date is invalid");
            findAndReserveARoom();
        }
        hotelResource.findARoom(checkInDate, checkOutDate).forEach(out::println);

        out.println();
        boolean reserve = enterYesOrNo("Would you like to book a room? (Y/N): ");
        if (!reserve) return;

        boolean hasAccount = enterYesOrNo("Do you have an account with us? (Y/N): ");
        Customer customer;
        if (hasAccount) {
            customer = enterExistingEmail("Enter Email (ex. name@domain.com): ");
        } else {
            customer = createAnAccount();
        }
        IRoom room = enterExistingRoomNo("Enter room number: ");
        Reservation reservation = hotelResource.bookARoom(customer.getEmail(), room, checkInDate, checkOutDate);
        out.println(reservation);
    }

    private void seeMyReservations() {
        String email = enterText("Enter customer account email: ");
        hotelResource.getCustomersReservations(email).forEach(out::println);
    }

    private Customer createAnAccount() {
        out.println("Create a new customer account:-");
        String email = enterText("Enter Email (ex. name@domain.com): ");
        String firstName = enterText("Enter First Name: ");
        String lastName = enterText("Enter Last Name: ");

        return hotelResource.createACustomer(email, firstName, lastName);
    }

    public void setAdminMenuNavigation(Runnable navigation) {
        menuOptions.get(4).setAction(navigation);
    }

}
