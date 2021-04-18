package com.example.routeoramaserver.controllers;

import com.example.routeoramaserver.networking.Connection;
import com.example.routeoramaserver.networking.IConnection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String Get(){
        IConnection connection = new Connection();
        connection.Start();
        return connection.FetchData();
    }
}
