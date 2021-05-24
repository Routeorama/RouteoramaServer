package com.example.routeoramaserver.controllers.user.rmi;

import com.example.routeoramaserver.models.User;

public interface IUserClient {
    void Start();
    User Login(String username, String password);
    boolean Register(User user);
    String UpdateUser(User user);
}
