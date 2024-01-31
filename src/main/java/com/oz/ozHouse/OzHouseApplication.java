package com.oz.ozHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class OzHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(OzHouseApplication.class, args);
        System.out.println("ozHouse 실행 완료!");
    }

}