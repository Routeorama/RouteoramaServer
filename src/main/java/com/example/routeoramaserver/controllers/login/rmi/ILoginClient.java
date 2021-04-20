package com.example.routeoramaserver.controllers.login.rmi;

import com.example.routeoramaserver.models.User;

public interface ILoginClient {
    void Start();
    User Login(String username, String password);
    void Logout();
}
