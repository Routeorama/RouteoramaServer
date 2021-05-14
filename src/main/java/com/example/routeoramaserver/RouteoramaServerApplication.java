package com.example.routeoramaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouteoramaServerApplication {

    public static void main(String[] args) {
        System.setProperty("java.security.policy", "src\\main\\security.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        SpringApplication.run(RouteoramaServerApplication.class, args);
    }

}
