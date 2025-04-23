package com.kalyan.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.aspectj.bridge.IMessage;

public class PatientRequestDTO {
    @NotBlank(message = "should not be blank")
    @Size(max=100, message = "Name should not be more than 100 Character")
    private String name;
    @NotBlank(message = "Should not be blank")
    @Email(message = "Use valid Email")
    private String email;

    @NotBlank(message="Cant be Blank")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotBlank(message = "Should not be blank")

    private String dateOfBirth;

    @NotBlank(message = "Should not be blank")
    private String registeredDate;



public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getDateOfBirth() {
    return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
}

public String getRegisteredDate() {
    return registeredDate;
}

public void setRegisteredDate(String registeredDate) {
    this.registeredDate = registeredDate;
}
}
