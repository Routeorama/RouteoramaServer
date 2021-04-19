package com.example.routeoramaserver;

import com.example.routeoramaserver.controllers.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class RouteoramaServerApplication {

    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("java.security.policy", "src\\main\\security.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        TestController testController = new TestController();
        SpringApplication.run(RouteoramaServerApplication.class, args);

    }

}
