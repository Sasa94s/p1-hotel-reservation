package com.melsheikh.hotelreservation.main;

import com.melsheikh.hotelreservation.api.AdminResource;
import com.melsheikh.hotelreservation.api.HotelResource;
import com.melsheikh.hotelreservation.repositories.CustomerRepository;
import com.melsheikh.hotelreservation.repositories.ReservationRepository;
import com.melsheikh.hotelreservation.repositories.RoomRepository;
import com.melsheikh.hotelreservation.services.CustomerService;
import com.melsheikh.hotelreservation.services.ReservationService;
import com.melsheikh.hotelreservation.views.AdminMenu;
import com.melsheikh.hotelreservation.views.MainMenu;
import com.melsheikh.hotelreservation.views.NavigationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IoCContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public IoCContainer() {
        // Manual wiring of dependencies
        instances.put(RoomRepository.class, RoomRepository.getInstance());
        instances.put(CustomerRepository.class, CustomerRepository.getInstance());
        instances.put(ReservationRepository.class, ReservationRepository.getInstance());
        instances.put(CustomerService.class, new CustomerService(getInstance(CustomerRepository.class)));
        instances.put(ReservationService.class, new ReservationService(
                getInstance(ReservationRepository.class),
                getInstance(RoomRepository.class)
        ));
        instances.put(AdminResource.class, new AdminResource(
                getInstance(CustomerService.class),
                getInstance(ReservationService.class)
        ));
        instances.put(HotelResource.class, new HotelResource(
                getInstance(CustomerService.class),
                getInstance(ReservationService.class)
        ));
        instances.put(Scanner.class, new Scanner(System.in));
        instances.put(AdminMenu.class, new AdminMenu(
                getInstance(Scanner.class),
                getInstance(AdminResource.class)
        ));
        instances.put(MainMenu.class, new MainMenu(
                getInstance(Scanner.class),
                getInstance(HotelResource.class)
        ));
        instances.put(NavigationContext.class, new NavigationContext(
                getInstance(MainMenu.class),
                getInstance(AdminMenu.class)
        ));
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance(Class<T> classType) {
        return (T) instances.get(classType);
    }
}

