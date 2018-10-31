package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class UnrestrictedActivity implements Activity {

    @Override
    public String getResource() {
        return "public";
    }
}
