package com.example.routeoramaserver.controllers.place.rmi;

import com.example.routeoramaserver.callbacks.place.PlaceClientCallback;
import com.example.routeoramaserver.models.Place;
import com.example.routeoramaserver.callbacks.place.IPlaceServerCallback;
import com.example.routeoramaserver.networking.ServerConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


public class PlaceClient implements IPlaceClient, PlaceClientCallback {

    private IPlaceServerCallback server;

    @Override
    public void Start() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            server = ServerConnection.getServerCallback().getPlaceServer();
        } catch (RemoteException e) {
            throw new RuntimeException("Could not fetch server.");
        }
    }

    @Override
    public Place NewPlace(Place place) {
        try {
            return server.NewPlace(place);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when creating new place.");
        }
        return null;
    }

    @Override
    public Place GetPlace(String place) {
        try {
            return server.GetPlace(place);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when getting a place.");
        }
        return null;
    }

    @Override
    public Place GetPlace(Double lat, Double lng) {
        try {
            return server.GetPlace(lat, lng);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when getting a place.");
        }
        return null;
    }

    @Override
    public List<Place> GetPlacesInBounds(List<Double> bounds) {
        try {
            return server.GetPlacesInBounds(bounds);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when getting places within bounds.");
        }
        return null;
    }

    @Override
    public void FollowThePlace(int placeId, int userId) {
        try {
            server.FollowThePlace(placeId, userId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when trying to follow a place.");
        }
    }

    @Override
    public void UnfollowThePlace(int placeId, int userId) {
        try {
            server.UnfollowThePlace(placeId, userId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when trying to follow a place.");
        }
    }

    @Override
    public boolean IsAlreadyFollowed(int placeId, int userId) {
        try {
            return server.IsAlreadyFollowed(placeId, userId);
        } catch (RemoteException e) {
            System.out.println("Could not contact server when trying to check for the follow.");
        }
        return false;
    }

    @Override
    public List<String> GetMostFollowedPlaces() {
        try{
            return server.GetMostFollowedPlaces();
        } catch (Exception e){
            System.out.println("Could not contact server when trying to get most followed places");
        }
         return null;
    }

    @Override
    public List<String> GetMostLikedPlaces() {
        try{
            return server.GetMostLikedPlaces();
        } catch (Exception e){
            System.out.println("Could not contact server when trying to get most liked places");
        }
        return null;
    }

    @Override
    public List<Place> SearchForPlace(String name) {
        try{
            return server.SearchForPlace(name);
        } catch (Exception e){
            System.out.println("Could not contact server when trying to search for a place");
        }
        return null;
    }
}
