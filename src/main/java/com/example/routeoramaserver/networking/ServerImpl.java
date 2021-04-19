package com.example.routeoramaserver.networking;


import com.example.routeoramaserver.networking.callbacks.ClientCallback;
import com.example.routeoramaserver.networking.callbacks.ServerCallback;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements ClientCallback, IServer {

    private ServerCallback server;

    @Override
    public void Start() {
        try{
            UnicastRemoteObject.exportObject(this, 0);
            server = (ServerCallback) LocateRegistry.getRegistry("localhost", 1099).lookup("RouteoramaServer");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String FetchData() {
        try{
            return server.getTestingStuff();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
