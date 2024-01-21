package com.melsheikh.hotelreservation.views.base;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.in;
import static java.lang.System.out;

public class AbstractMenu implements Menu {
    private final Scanner scanner = new Scanner(in);
    protected final Map<Integer, MenuItem> menuOptions;
    protected static final AtomicInteger currentChoice = new AtomicInteger(-1);

    protected AbstractMenu(Map<Integer, MenuItem> menuOptions) {
        this.menuOptions = menuOptions;
    }

    @Override
    public void displayMenu() {
        for (Map.Entry<Integer, MenuItem> entry : menuOptions.entrySet()) {
            out.printf("%d. %s%n", entry.getKey(), entry.getValue().getTitle());
        }
        out.printf("Please select a number for the menu option [%d...%d]%n", 1, menuOptions.size());
        currentChoice.set(scanner.nextInt());
    }

    @Override
    public void processMenu() {
        menuOptions.get(currentChoice.get()).executeAction();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
