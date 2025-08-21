package com.example.demo1;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }
}