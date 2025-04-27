package com.kalyan.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {
    @NotBlank(message = "Email Should Not be blank")
    @Email(message = "Email Should Be Valid")
    private String email;

    @NotBlank(message = "Password Should Not be blank")
    @Size(min = 8,message = "Password Must be at least * character")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
