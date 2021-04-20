package com.example.routeoramaserver.controllers;

import com.example.routeoramaserver.networking.server.IServer;
import com.example.routeoramaserver.networking.server.ServerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    // will probably fail without necessary precautions
    // tried making it still fit the structure, will be removed after working with Karlo on actual auth
    private final IServer connection;

    public TestController() {
        connection = new ServerImpl();
        connection.Start();
    }

    @GetMapping("/api/test")
    public String Get() {
        return connection.FetchData();
    }
}
