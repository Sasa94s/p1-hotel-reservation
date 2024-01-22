package com.melsheikh.hotelreservation.views;

public class NavigationContext {

    public NavigationContext(MainMenu mainMenu, AdminMenu adminMenu) {
        mainMenu.setAdminMenuNavigation(adminMenu::displayMenu);
        adminMenu.setMainMenuNavigation(mainMenu::displayMenu);
    }


}
