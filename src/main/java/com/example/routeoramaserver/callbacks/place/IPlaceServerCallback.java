package com.example.routeoramaserver.callbacks.place;

import com.example.routeoramaserver.models.Place;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * server interface for RMI
 * */
public interface IPlaceServerCallback extends Remote {
    Place NewPlace(Place place) throws RemoteException;

    Place GetPlace(String place) throws RemoteException;

    Place GetPlace(Double lat, Double lng) throws RemoteException;
}
