package com.esti.productmanager.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProductDto {
    private Long id;


    @Size(min = 2, message = "Name is to short")
    @NotNull
    private String name;

    private String description;



    @Min(value = 1, message = "Price is at least 1")
    @NotNull
    private Float price;
}
