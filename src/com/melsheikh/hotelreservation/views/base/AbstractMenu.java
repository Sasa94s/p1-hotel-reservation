package com.melsheikh.hotelreservation.views.base;

import com.melsheikh.hotelreservation.constants.Constants;
import com.melsheikh.hotelreservation.helpers.DateHelper;
import com.melsheikh.hotelreservation.helpers.EnumHelper;
import com.melsheikh.hotelreservation.models.types.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.err;
import static java.lang.System.out;

public abstract class AbstractMenu implements Menu {
    private boolean isRunning;
    protected Scanner scanner;
    protected final Map<Integer, MenuItem> menuOptions;
    protected static final AtomicInteger currentChoice = new AtomicInteger(-1);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    protected AbstractMenu(Scanner scanner, Map<Integer, MenuItem> menuOptions) {
        this.scanner = scanner;
        this.menuOptions = menuOptions;
        this.isRunning = true;
    }

    @Override
    public void displayMenu() {
        out.println("-".repeat(Constants.CONSOLE_WIDTH));
        for (Map.Entry<Integer, MenuItem> entry : menuOptions.entrySet()) {
            out.printf("%d. %s%n", entry.getKey(), entry.getValue().getTitle());
        }
        out.println("-".repeat(Constants.CONSOLE_WIDTH));
        int choice = enterInteger(String.format("Please select a number for the menu option [%d...%d]%n", 1, menuOptions.size()));
        currentChoice.set(choice);
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
                    if (isRunning) displayMenu();
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

    protected int enterInteger(String s) {
        out.print(s);
        try {
            return Integer.parseInt(scanner.next());
        } catch (Exception e) {
            out.println("Error " + e.getMessage());
            return enterInteger(s);
        }
    }

    protected double enterDouble(String s) {
        out.print(s);
        try {
            return Double.parseDouble(scanner.next());
        } catch (Exception e) {
            out.println("Error " + e.getMessage());
            return 0.0d;
        }
    }

    protected Date enterDate(String s) {
        try {
            String date = enterText(s);
            return stripTime(DateHelper.parseDate(date));
        } catch (Exception e) {
            out.println("Invalid date format");
        }

        return enterDate(s);
    }

    public static Date stripTime(Date date) {
        try {
            return dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    public void close() {
        scanner.close();
    }

    protected void exit() {
        isRunning = false;
        scanner.close();
        out.println("Goodbye!");
    }
}
