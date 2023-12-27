package com.mappingbasics.basesmapping.controller;

import com.mappingbasics.basesmapping.service.JWTService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private JWTService jwtService;

    public LoginController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(Authentication authentication){
        return  jwtService.generateToken(authentication);
    }
}
