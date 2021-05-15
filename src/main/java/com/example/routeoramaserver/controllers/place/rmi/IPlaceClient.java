package com.example.routeoramaserver.controllers.place.rmi;

import com.example.routeoramaserver.models.Place;

import java.rmi.RemoteException;
import java.util.List;

public interface IPlaceClient {
    void Start();
    Place NewPlace(Place place);

    Place GetPlace(String place);

    Place GetPlace(Double lat, Double lng);

    List<Place> GetPlacesInBounds(List<Double> bounds);

    void FollowThePlace(int placeId, int userId);
    void UnfollowThePlace(int placeId, int userId);
    boolean IsAlreadyFollowed(int placeId, int userId);
}
