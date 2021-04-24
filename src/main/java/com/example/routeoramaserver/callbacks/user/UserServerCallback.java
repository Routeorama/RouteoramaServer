package com.example.routeoramaserver.callbacks.user;

import com.example.routeoramaserver.models.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
* server interface for RMI
* */
public interface UserServerCallback extends Remote {
    User Login(String username, String password) throws RemoteException;
    void Logout() throws RemoteException;
    boolean Register(User user) throws RemoteException;
}
