package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class RestrictedActivity implements Activity {

    @Override
    public String getResource() {
        return "protected";
    }
}
