package com.anton.service.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class User {
    @NotEmpty(message = "Please provide a firstName")
    private String firstName;
    @NotEmpty(message = "Please provide a secondName")
    private String secondName;
    @NotEmpty(message = "Please provide an mail")
    private String mail;
    @NotEmpty(message = "Please provide a password")
    private String password;

}
