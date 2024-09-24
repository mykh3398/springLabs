package com.example.HelloWorld1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class FirstBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("FIRST");
    }
}
