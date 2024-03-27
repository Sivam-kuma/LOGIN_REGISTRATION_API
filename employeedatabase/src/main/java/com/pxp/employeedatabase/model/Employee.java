package com.pxp.employeedatabase.model;

public class Employee {
    public int id;
    public String firstName;
    public String lastName;

    // Default constructor
    public Employee() {
    }

    // Getter and setter methods for id, firstName, and lastName
    // These methods are used to access and modify the values of the fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
