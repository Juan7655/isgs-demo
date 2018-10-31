package com.example.demo.controllers;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private UserService user;

    @GetMapping(value = "/get", produces = "application/json")
    @ResponseBody
    public ResponseEntity getAllCandidates(@RequestHeader("Authorization") String token) {
        int intToken;

        try {
            intToken = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The token is not a number");
        }

        user.setNameFromToken(intToken);
        return ResponseEntity.status(HttpStatus.OK).body(user.execute());
    }

}
