package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SystemController {

    @GetMapping(value = "/ping")
    public ResponseEntity defaultOk() {
        return ResponseEntity.status(HttpStatus.OK).body("pong");
    }

    @GetMapping(value = "/error")
    public ResponseEntity defaultError() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The resource you were trying to search was not found");
    }
}
