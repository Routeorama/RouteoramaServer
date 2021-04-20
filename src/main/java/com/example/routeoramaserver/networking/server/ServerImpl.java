package com.example.routeoramaserver.networking.server;

import com.example.routeoramaserver.networking.ServerConnection;
import com.example.routeoramaserver.networking.callbacks.ClientCallback;
import com.example.routeoramaserver.networking.callbacks.ServerCallback;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements ClientCallback, IServer {
    // deprecated
    private ServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String FetchData() {
        try {
            return server.getTestingStuff();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
