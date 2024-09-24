package com.example.HelloWorld1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class SecondBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("SECOND");
    }
}
