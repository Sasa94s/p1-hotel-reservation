package com.melsheikh.hotelreservation.main;

import com.melsheikh.hotelreservation.models.Customer;
import com.melsheikh.hotelreservation.models.Reservation;
import com.melsheikh.hotelreservation.models.Room;
import com.melsheikh.hotelreservation.models.types.RoomType;
import com.melsheikh.hotelreservation.repositories.CustomerRepository;
import com.melsheikh.hotelreservation.repositories.ReservationRepository;
import com.melsheikh.hotelreservation.repositories.RoomRepository;
import com.melsheikh.hotelreservation.services.CustomerService;
import com.melsheikh.hotelreservation.services.ReservationService;

import java.util.Date;

import static java.lang.System.out;

public class Tester {

    public static void main(String[] args) {
        createValidCustomer();
//        createInvalidCustomer();
        createValidRoom();
//        createInvalidRoom();
        createValidReservation();
//        createInvalidReservation();
        addCustomers();
        getAllCustomers();
        addRooms();
        getAllRooms();
        addReservations();
        getAllReservations();
//        addExistingCustomer();
        addNewCustomer();
        getNewCustomer();
        addNewRoom();
        getNewRoom();
        reserveNewRoom();
//        reserveExisting();
        reserveExistingDiffDate();
    }

    private static void createValidCustomer() {
        Customer customer = new Customer("Mostafa", "ElSheikh", "mosta@peaq.com");
        out.println(customer);
    }

    private static void createInvalidCustomer() {
        Customer customer = new Customer("first", "second", "email");
        out.println(customer);
    }

    private static void createValidRoom() {
        Room room = new Room("1", 100.0, RoomType.SINGLE);
        out.println(room);
    }

    private static void createInvalidRoom() {
        Room room = new Room("1", -100.0, RoomType.SINGLE);
        out.println(room);
    }

    private static void createValidReservation() {
        Reservation reservation = new Reservation(
                new Customer("Mostafa", "ElSheikh", "m@e.co"),
                new Room("1", 100.0, RoomType.SINGLE),
                new Date(2021, 1, 1),
                new Date(2021, 1, 2)
        );
        out.println(reservation);
    }

    private static void createInvalidReservation() {
        Reservation reservation = new Reservation(
                new Customer("Mostafa", "ElSheikh", "m@e.co"),
                new Room("1", 100.0, RoomType.SINGLE),
                null,
                null
        );
        out.println(reservation);
    }

    private static void addCustomers() {
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        customerRepository.save(new Customer("Mostafa", "ElSheikh", "a@e.co"));
        customerRepository.save(new Customer("Ahmed", "Hamdy", "m@h.co"));
    }

    private static void getAllCustomers() {
        CustomerRepository customerRepository = CustomerRepository.getInstance();
        customerRepository.findAll().forEach(out::println);
    }

    private static void addRooms() {
        RoomRepository roomRepository = RoomRepository.getInstance();
        roomRepository.save(new Room("1", 100.0, RoomType.SINGLE));
        roomRepository.save(new Room("2", 200.0, RoomType.DOUBLE));
    }

    private static void getAllRooms() {
        RoomRepository roomRepository = RoomRepository.getInstance();
        roomRepository.findAll().forEach(out::println);
    }

    private static void addReservations() {
        ReservationRepository reservationRepository = ReservationRepository.getInstance();
        reservationRepository.save(new Reservation(
                new Customer("Mostafa", "ElSheikh", "a@e.co"),
                new Room("1", 100.0, RoomType.SINGLE),
                new Date(2021, 1, 1),
                new Date(2021, 1, 2)
        ));
        reservationRepository.save(new Reservation(
                new Customer("Ahmed", "Hamdy", "m@h.co"),
                new Room("2", 200.0, RoomType.DOUBLE),
                new Date(2021, 1, 1),
                new Date(2021, 1, 2)
        ));
    }

    private static void getAllReservations() {
        ReservationRepository reservationRepository = ReservationRepository.getInstance();
        reservationRepository.findAll().forEach(out::println);
    }

    private static void addExistingCustomer() {
        CustomerService customerService = new CustomerService(CustomerRepository.getInstance());
        customerService.addCustomer("a@e.co", "A", "B");
        customerService.printAllCustomers();
    }

    private static void addNewCustomer() {
        CustomerService customerService = new CustomerService(CustomerRepository.getInstance());
        customerService.addCustomer("a@b.co", "A", "B");
        customerService.printAllCustomers();
    }

    private static void getNewCustomer() {
        CustomerService customerService = new CustomerService(CustomerRepository.getInstance());
        out.println(customerService.getCustomer("a@b.co"));
    }

    private static void addNewRoom() {
        Room room = new Room("A120", 125.0, RoomType.SINGLE);
        ReservationService reservationService = new ReservationService(
                ReservationRepository.getInstance(),
                RoomRepository.getInstance()
        );
        reservationService.addRoom(room);
        out.println(reservationService.getARoom("A120"));
    }

    private static void getNewRoom() {
        ReservationService reservationService = new ReservationService(
                ReservationRepository.getInstance(),
                RoomRepository.getInstance()
        );
        out.println(reservationService.getARoom("A120"));;
    }

    private static void reserveNewRoom() {
        ReservationService reservationService = new ReservationService(
                ReservationRepository.getInstance(),
                RoomRepository.getInstance()
        );
        reservationService.reserveARoom(
                new Customer("W", "Jr", "jr@e.co"),
                new Room("A120", 125.0, RoomType.SINGLE),
                new Date(2021, 1, 1),
                new Date(2021, 1, 2)
        );
        reservationService.printAllReservation();
    }

    private static void reserveExisting() {
        ReservationService reservationService = new ReservationService(
                ReservationRepository.getInstance(),
                RoomRepository.getInstance()
        );
        reservationService.reserveARoom(
                new Customer("A", "B", "a@b.co"),
                new Room("A120", 125.0, RoomType.SINGLE),
                new Date(2021, 1, 1),
                new Date(2021, 1, 2)
        );
        reservationService.printAllReservation();
    }

    private static void reserveExistingDiffDate() {
        ReservationService reservationService = new ReservationService(
                ReservationRepository.getInstance(),
                RoomRepository.getInstance()
        );
        reservationService.reserveARoom(
                new Customer("A", "B", "a@b.co"),
                new Room("A120", 125.0, RoomType.SINGLE),
                new Date(2021, 1, 3),
                new Date(2021, 1, 4)
        );
        reservationService.printAllReservation();
    }
}
