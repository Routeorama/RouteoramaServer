package com.example.routeoramaserver.controllers.place;

import com.example.routeoramaserver.controllers.place.rmi.IPlaceClient;
import com.example.routeoramaserver.controllers.place.rmi.PlaceClient;
import com.example.routeoramaserver.models.Place;
import com.example.routeoramaserver.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PlaceController {
    private IPlaceClient placeClient;

    public PlaceController() {
        placeClient = new PlaceClient();
        placeClient.Start();
    }

    @PostMapping(value = "/place", consumes = "application/json", produces = "application/json")
    public Place NewPlace(@RequestBody Place place){
        return placeClient.NewPlace(place);
    }
}
