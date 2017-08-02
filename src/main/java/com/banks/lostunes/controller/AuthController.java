package com.banks.lostunes.controller;

import com.banks.lostunes.pojo.TokenPojo;
import com.banks.lostunes.util.TokenProvider;
import com.banks.lostunes.vm.UserVM;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by banks on 8/1/17.
 */
@RestController("/api/v2/auth")
@Log4j
public class AuthController {

    private AuthenticationManager authenticationManager;
    private TokenProvider tokenProvider;

    public AuthController(AuthenticationManager authenticationManager, TokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody UserVM user, HttpServletResponse response) {
        log.debug(user);

        if (user == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (AuthenticationException e) {
            log.error("AuthenticationException while logging in");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        String token = tokenProvider.generateToken(authentication, false);
        response.addHeader(TokenProvider.AUTHORIZATION_HEADER, "Bearer " + token);

        return ResponseEntity.ok(new TokenPojo(token));
    }
}
