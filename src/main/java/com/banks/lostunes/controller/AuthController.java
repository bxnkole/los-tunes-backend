package com.banks.lostunes.controller;

import com.banks.lostunes.vm.UserVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by banks on 8/1/17.
 */
@RestController("/v2/auth")
public class AuthController {

    @PostMapping
    public String login(@RequestBody UserVM user) {
        if(user == null) {
            return ResponseEntity.unprocessableEntity().toString();
        }

        String username = user.getUsername();
        String password = user.getPassword();

        return "";
    }
}
