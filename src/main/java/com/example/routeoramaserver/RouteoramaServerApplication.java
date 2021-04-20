package com.example.routeoramaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;

@SpringBootApplication
public class RouteoramaServerApplication {

    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("java.security.policy", "src\\main\\security.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        //TODO clean-up and remove testing code
        SpringApplication.run(RouteoramaServerApplication.class, args);

    }

}
