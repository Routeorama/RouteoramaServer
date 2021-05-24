package com.example.routeoramaserver.controllers.user.rmi;

import com.example.routeoramaserver.callbacks.user.UserClientCallback;
import com.example.routeoramaserver.callbacks.user.IUserServerCallback;
import com.example.routeoramaserver.models.User;
import com.example.routeoramaserver.networking.ServerConnection;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserClient implements IUserClient, UserClientCallback {

    private IUserServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback().getUserServer();
        } catch (RemoteException e) {
            System.out.println("Could not contact server.");
        }
    }

    @Override
    public User Login(String username, String password) {
        try {
            return server.Login(username, password);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when validating login.");
        }
        return null;
    }

    @Override
    public boolean Register(User user) {
        try {
            return server.Register(user);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when registering.");
        }
        return false;
    }

    @Override
    public String UpdateUser(User user) {
        try {
            return server.UpdateUser(user);
        } catch (RemoteException e) {
            System.out.println("Could not update user information.");
        }
        return null;
    }
}
