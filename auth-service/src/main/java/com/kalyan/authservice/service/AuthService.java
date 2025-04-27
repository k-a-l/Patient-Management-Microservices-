package com.kalyan.authservice.service;

import com.kalyan.authservice.dto.LoginRequestDTO;
import com.kalyan.authservice.model.User;
import com.kalyan.authservice.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

//    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
//        return userService.findByEmail(loginRequestDTO.getEmail())
//                .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
//                .map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole()));
//    }
public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
    log.info("Trying to authenticate email: {}", loginRequestDTO.getEmail());

    return userService.findByEmail(loginRequestDTO.getEmail())
            .map(u -> {
                boolean match = passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword());
                log.info("Password match: {}", match);

                return match ? jwtUtil.generateToken(u.getEmail(), u.getRole()) : null;
            });
}
public boolean validateToken(String token){
    try {
        jwtUtil.validateToken(token);
        return true;
    }catch (Exception ex){
        return false;
    }

}

}
