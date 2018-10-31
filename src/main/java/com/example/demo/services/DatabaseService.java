package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    protected String searchDatabase(int token){
        return token == 1 ? "Juan" : null;
    }
}
