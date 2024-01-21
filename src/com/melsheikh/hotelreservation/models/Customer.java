package com.melsheikh.hotelreservation.models;

import com.melsheikh.hotelreservation.validators.EmailValidator;

public class Customer implements Entity<String> {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email){
        if(!EmailValidator.getInstance().isValid(email)){
            throw new IllegalArgumentException("Invalid email address");
        }
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String getId() {
        return this.email;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
