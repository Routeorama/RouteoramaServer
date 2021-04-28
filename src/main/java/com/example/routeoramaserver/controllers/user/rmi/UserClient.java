package com.example.routeoramaserver.controllers.user.rmi;

import com.example.routeoramaserver.callbacks.user.UserClientCallback;
import com.example.routeoramaserver.callbacks.user.IUserServerCallback;
import com.example.routeoramaserver.models.User;
import com.example.routeoramaserver.networking.ServerConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
* Login client used to handle auth requests to and from the DB server
* can later be changed to handle registering and account state as well (deleting and such)
* */
public class UserClient implements IUserClient, UserClientCallback {

    private IUserServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback().getUserServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User Login(String username, String password) {
        try {
            return server.Login(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void Logout() {
        try {
            server.Logout();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean Register(User user) {
        try {
            return server.Register(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }
}
