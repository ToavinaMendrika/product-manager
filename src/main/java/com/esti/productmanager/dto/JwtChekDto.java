package com.esti.productmanager.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class JwtChekDto {
    @NotNull
    private String jwt;
}
