package com.esti.productmanager.services;

import com.esti.productmanager.dto.ProductDto;
import com.esti.productmanager.dto.UserDto;
import com.esti.productmanager.entities.Product;
import com.esti.productmanager.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    ModelMapper modelMapper;


    public UserDto createAdmin()
    {
        com.esti.productmanager.entities.User user = new com.esti.productmanager.entities.User();
        user.setUsername("admin");
        user.setPassword(encoder.encode("admin"));
        user.setFullName("John Doe");
        user.setEmail("admin@mail.com");
        com.esti.productmanager.entities.User userExist = userRepository.findAllByUsername("admin");
        if (userExist == null) {
            com.esti.productmanager.entities.User user1 = userRepository.saveAndFlush(user);
            return convertEntityToDto(user1);
        }
        return convertEntityToDto(userExist);
    }

    private UserDto convertEntityToDto(com.esti.productmanager.entities.User user)
    {
        return modelMapper.map(user, UserDto.class);
    }

    private User convertDtoToEntity(UserDto userDto)
    {
        return modelMapper.map(userDto, User.class);
    }
}
