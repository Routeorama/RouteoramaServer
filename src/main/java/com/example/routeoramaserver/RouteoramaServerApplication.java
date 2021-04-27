package com.example.routeoramaserver;

import com.example.routeoramaserver.controllers.place.rmi.PlaceClient;
import com.example.routeoramaserver.controllers.user.rmi.UserClient;
import com.example.routeoramaserver.models.Location;
import com.example.routeoramaserver.models.Place;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RouteoramaServerApplication {

    public static void main(String[] args) {

        System.setProperty("java.security.policy", "src\\main\\security.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        //TODO clean-up and remove testing code
        SpringApplication.run(RouteoramaServerApplication.class, args);
    }

}
