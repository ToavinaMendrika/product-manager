package com.esti.productmanager.services;

import com.esti.productmanager.dto.ProductDto;
import com.esti.productmanager.entities.Product;
import com.esti.productmanager.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public List<ProductDto> getAll()
    {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ProductDto create(ProductDto productDto)
    {
        Product product = convertDtoToEntity(productDto);
        Product p1 = repository.saveAndFlush(product);
        return convertEntityToDto(p1);
    }

    public ProductDto findById(Long id)
    {
        Optional<Product> product = repository.findById(id);
        return convertEntityToDto(product.get());
    }

    public ProductDto edit(ProductDto productDto, Long id)
    {
        Product product = convertDtoToEntity(productDto);
        product.setId(id);
        Product p1 = repository.save(product);
        return convertEntityToDto(p1);
    }

    public ProductDto delete(Long id)
    {
        ProductDto product = findById(id);
        repository.deleteById(id);
        return  product;
    }

    private ProductDto convertEntityToDto(Product product)
    {
        ProductDto productDto = new ProductDto();
        return modelMapper.map(product, ProductDto.class);
    }

    private Product convertDtoToEntity(ProductDto productDto)
    {
        Product product = new Product();
        return modelMapper.map(productDto, Product.class);
    }
}
