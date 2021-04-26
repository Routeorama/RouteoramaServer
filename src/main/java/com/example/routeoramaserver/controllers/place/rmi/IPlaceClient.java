package com.example.routeoramaserver.controllers.place.rmi;

import com.example.routeoramaserver.models.Place;

public interface IPlaceClient {
    void Start();
    Place NewPlace(Place place);
}
