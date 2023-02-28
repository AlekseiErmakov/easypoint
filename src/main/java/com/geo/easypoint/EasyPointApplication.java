package com.geo.easypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class EasyPointApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyPointApplication.class, args);
    }

}
