package com.esti.productmanager.controllers;

import com.esti.productmanager.dto.AuthenticationResponseDto;
import com.esti.productmanager.dto.UserDto;
import com.esti.productmanager.services.UserDetailsService;
import com.esti.productmanager.services.UserService;
import com.esti.productmanager.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/api/auth/createadmin")
    public UserDto initAdmin()
    {
        return userService.createAdmin();
    }

    @PostMapping("/api/authenticate")
    public ResponseEntity<?> authenticate(@Valid  @RequestBody UserDto userDto) throws Exception {
        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                    userDto.getUsername(), userDto.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(userDto.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDto(jwt));
    }
}
