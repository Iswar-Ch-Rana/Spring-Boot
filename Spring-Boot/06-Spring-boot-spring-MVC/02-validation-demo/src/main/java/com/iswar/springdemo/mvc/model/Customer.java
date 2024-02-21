package com.iswar.springdemo.mvc.model;

import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    @Min(value=0, message = "must be grater then equal to zero")
    @Max(value=10, message = "must be less then or equal to 10")
    private Integer freePass;

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName ;

    @Pattern(regexp = "[0-9]{5}" , message = "The pin should be 5 Number")
    private String postalCode;


    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
