package com.example.routeoramaserver.networking;

import com.example.routeoramaserver.networking.callbacks.ServerCallback;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerConnection {
    private static ServerCallback serverCallback;
    private static final Lock lock = new ReentrantLock();

    private ServerConnection() {
    }

    /*
    * this will fetch the server factory which will then provide all of the necessary interfaces for each separate server
    * there will be one server for one specific thing a.k.a. one for user related things (registering, logging in, etc),
    * one for posts and places, etc. etc.
    *
    * TODO some renaming should be done about the server impl and interfaces in the DB server, technically not important
    * */
    public static ServerCallback getServerCallback() {
        if (serverCallback == null) {
            synchronized (lock) {
                if (serverCallback == null) {
                    try {
                        serverCallback = (ServerCallback) LocateRegistry.getRegistry("localhost", 1099).lookup("RouteoramaServer");
                    } catch (NotBoundException | RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return serverCallback;
    }
}
