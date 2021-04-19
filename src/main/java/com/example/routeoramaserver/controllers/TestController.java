package com.example.routeoramaserver.controllers;

import com.example.routeoramaserver.networking.IServer;
import com.example.routeoramaserver.networking.ServerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final IServer connection;

    public TestController(){
        connection = new ServerImpl();
        connection.Start();
    }
    @GetMapping("/api/test")
    public String Get(){
        return connection.FetchData();
    }
}
