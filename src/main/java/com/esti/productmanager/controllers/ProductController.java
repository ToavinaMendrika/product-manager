package com.esti.productmanager.controllers;

import com.esti.productmanager.dto.ProductDto;
import com.esti.productmanager.entities.Product;
import com.esti.productmanager.exceptions.ResourceNotFoundException;
import com.esti.productmanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<ProductDto> getAll()
    {
        return productService.getAll();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto create(@Valid  @RequestBody ProductDto productDto)
    {
        return productService.create(productDto);
    }

   @GetMapping("/{id}")
    public ProductDto get(@PathVariable(value = "id") Long id)
    {
        try {
            return productService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException();
        }

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto update(@Valid  @RequestBody ProductDto productDto,  @PathVariable(value = "id") Long id)
    {
        try {
             productService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException();
        }

        return productService.edit(productDto, id);
    }

    @DeleteMapping(value = "/{id}")
    public ProductDto delete(@PathVariable(value = "id") Long id)
    {
        try {
            productService.findById(id);
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException();
        }

        return productService.delete(id);
    }
}
