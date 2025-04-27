package com.kalyan.authservice.controller;

import com.kalyan.authservice.dto.LoginRequestDTO;
import com.kalyan.authservice.dto.LoginResponseDTO;
import com.kalyan.authservice.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthService authService;

    @Operation(summary = "Generate login token")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<String> tokanOptional=authService.authenticate(loginRequestDTO);

        if(tokanOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }
        String token=tokanOptional.get();
        log.info("The generated token {}",token);
        return ResponseEntity.ok(new LoginResponseDTO(token));



    }
}
