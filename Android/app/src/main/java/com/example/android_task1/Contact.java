package com.example.android_task1;


public class Contact {

    String firstName;
    String lastName;
    String phoneNumber;


    public Contact(String firstName, String lastName, String phoneNumber){

        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString()
    {
        return("Etunimi "+ this.getFirstName()+
                ".\nSukunimi " +
                this.getLastName()+"\nPuhelinnumero " + this.getPhoneNumber());
    }

}

