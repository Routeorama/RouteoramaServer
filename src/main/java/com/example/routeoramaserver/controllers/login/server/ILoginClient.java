package com.example.routeoramaserver.controllers.login.server;

import com.example.routeoramaserver.models.User;

public interface ILoginClient {
    void Start();
    User Login(String username, String password);
    void Logout();
}
