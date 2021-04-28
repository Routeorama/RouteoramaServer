package com.example.routeoramaserver.controllers.place.rmi;

import com.example.routeoramaserver.callbacks.place.PlaceClientCallback;
import com.example.routeoramaserver.models.Place;
import com.example.routeoramaserver.callbacks.place.IPlaceServerCallback;
import com.example.routeoramaserver.networking.ServerConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
* Login client used to handle auth requests to and from the DB server
* can later be changed to handle registering and account state as well (deleting and such)
* */
public class PlaceClient implements IPlaceClient, PlaceClientCallback {

    private IPlaceServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback().getPlaceServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Place NewPlace(Place place) {
        try {
            return server.NewPlace(place);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
