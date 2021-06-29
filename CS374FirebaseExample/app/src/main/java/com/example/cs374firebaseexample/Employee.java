package com.example.cs374firebaseexample;

public class Employee {

    private String lastName, firstName;

    Employee() {
        this.lastName = "empty";
        this.firstName = "empty";
    }

    Employee (String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
