package com.melsheikh.hotelreservation.views.base;

public class MenuItem {
    private String title;
    private Runnable action;

    public MenuItem(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public Runnable getAction() {
        return action;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }

    public void executeAction() {
        if (action == null) {
            throw new UnsupportedOperationException("Action is not set");
        }

        action.run();
    }

    @Override
    public String toString() {
        return title;
    }
}
