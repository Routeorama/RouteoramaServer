package com.example.routeoramaserver;

import com.example.routeoramaserver.controllers.login.rmi.ILoginClient;
import com.example.routeoramaserver.networking.ServerConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

@SpringBootApplication
public class RouteoramaServerApplication {

    public static void main(String[] args) throws MalformedURLException {

        System.setProperty("java.security.policy", "src\\main\\security.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        //TODO clean-up and remove testing code
        SpringApplication.run(RouteoramaServerApplication.class, args);

        try {
            System.out.println(ServerConnection.getServerCallback().getLoginServer().Login("George", "george"));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
