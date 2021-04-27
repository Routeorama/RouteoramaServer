package com.example.routeoramaserver.controllers.place.rmi;

import com.example.routeoramaserver.callbacks.place.PlaceClientCallback;
import com.example.routeoramaserver.models.Place;
import com.example.routeoramaserver.callbacks.place.PlaceServerCallback;
import com.example.routeoramaserver.networking.callbacks.ClientCallback;
import com.example.routeoramaserver.networking.ServerConnection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
* Login client used to handle auth requests to and from the DB server
* can later be changed to handle registering and account state as well (deleting and such)
* */
public class PlaceClient implements IPlaceClient, PlaceClientCallback {

    private PlaceServerCallback server;

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
