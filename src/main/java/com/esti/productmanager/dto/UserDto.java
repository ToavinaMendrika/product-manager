package com.esti.productmanager.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String fullName;

    private String email;
}
