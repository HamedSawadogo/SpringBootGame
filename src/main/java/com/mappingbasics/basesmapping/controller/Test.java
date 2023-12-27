package com.mappingbasics.basesmapping.controller;

import com.mappingbasics.basesmapping.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Test {

    private final JWTService jwtService;

    public Test(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping(value = "/home")
    public String home(Authentication authentication){
        log.info("Nom de l'authentication: "+authentication.getName());
        return jwtService.generateToken(authentication);
    }
}
