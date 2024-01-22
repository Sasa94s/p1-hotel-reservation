package com.melsheikh.hotelreservation.views.base;

import com.melsheikh.hotelreservation.constants.Constants;
import com.melsheikh.hotelreservation.helpers.DateHelper;
import com.melsheikh.hotelreservation.helpers.EnumHelper;
import com.melsheikh.hotelreservation.models.types.RoomType;

import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.err;
import static java.lang.System.out;

public abstract class AbstractMenu implements Menu {
    protected Scanner scanner;
    protected final Map<Integer, MenuItem> menuOptions;
    protected static final AtomicInteger currentChoice = new AtomicInteger(-1);

    protected AbstractMenu(Scanner scanner, Map<Integer, MenuItem> menuOptions) {
        this.scanner = scanner;
        this.menuOptions = menuOptions;
    }

    @Override
    public void displayMenu() {
        out.println("-".repeat(Constants.CONSOLE_WIDTH));
        for (Map.Entry<Integer, MenuItem> entry : menuOptions.entrySet()) {
            out.printf("%d. %s%n", entry.getKey(), entry.getValue().getTitle());
        }
        out.println("-".repeat(Constants.CONSOLE_WIDTH));
        out.printf("Please select a number for the menu option [%d...%d]%n", 1, menuOptions.size());
        currentChoice.set(scanner.nextInt());
        processMenu();
    }

    @Override
    public void postConstruct() {
        menuOptions.keySet().forEach(i -> {
            MenuItem menuItem = menuOptions.get(i);
            Runnable action = menuItem.getAction();
            menuOptions.get(i).setAction(() -> {
                try {
                    out.printf("Loading '%s' menu option%n", menuItem.getTitle());
                    action.run();
                } catch (Exception e) {
                    err.printf("Error: %s%n", e.getMessage());
                } finally {
                    displayMenu();
                }
            });
        });
    }

    @Override
    public void processMenu() {
        menuOptions.get(currentChoice.get()).executeAction();
    }

    public boolean enterYesOrNo(String s) {
        out.println(s);
        String answer = scanner.next();
        if (answer == null ||
                (!answer.equalsIgnoreCase("Y") &&
                        !answer.equalsIgnoreCase("N"))
        ) {
            out.printf("Please enter Y (Yes) or N (No)%n");
            return enterYesOrNo(s);
        }

        return answer.equalsIgnoreCase("Y");
    }

    protected String enterText(String s) {
        out.print(s);

        try {
            return scanner.next();
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        return enterText(s);
    }

    protected RoomType enterConstant(String s) {
        out.print(s);
        try {
            return EnumHelper.getEnumConstant(RoomType.class, scanner.nextInt());
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        return enterConstant(s);
    }

    protected double enterDouble(String s) {
        out.print(s);
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            out.println(e.getMessage());
        }

        return enterDouble(s);
    }

    protected Date enterDate(String s) {
        try {
            String date = enterText(s);
            return DateHelper.parseDate(date);
        } catch (Exception e) {
            out.println("Invalid date format");
        }

        return enterDate(s);
    }

    @Override
    public void close() {
        scanner.close();
    }
}
