package com.example.demo.services;

import com.example.demo.domain.Activity;
import com.example.demo.domain.RestrictedActivity;
import com.example.demo.domain.UnrestrictedActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private String name;
    private Activity activity;

    @Value("${secret}")
    private String text;

    private final DatabaseService databaseService;

    @Autowired
    public UserService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public String execute() {
        activity = name != null ? new RestrictedActivity() : new UnrestrictedActivity();

        return activity.getResource() + text;
    }

    public void setNameFromToken(int token) {
        // search in database or external API for name
        this.name = databaseService.searchDatabase(token);
    }
}
