package com.example.routeoramaserver.networking.callbacks;

import com.example.routeoramaserver.callbacks.login.LoginServerCallback;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerCallback extends Remote {
    // this interface will have just get methods such as the one below
    // they're used to fetch the correct interfaces from the DB server
    LoginServerCallback getLoginServer() throws RemoteException;
}
