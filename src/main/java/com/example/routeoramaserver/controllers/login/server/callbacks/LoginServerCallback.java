package com.example.routeoramaserver.controllers.login.server.callbacks;

import com.example.routeoramaserver.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
* server interface for RMI
* */
public interface LoginServerCallback extends Remote {
    User Login(String username, String password) throws RemoteException;
    void Logout() throws RemoteException;
}
