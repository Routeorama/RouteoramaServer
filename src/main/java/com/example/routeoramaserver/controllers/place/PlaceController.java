package com.example.routeoramaserver.controllers.place;

import com.example.routeoramaserver.controllers.place.rmi.IPlaceClient;
import com.example.routeoramaserver.controllers.place.rmi.PlaceClient;
import com.example.routeoramaserver.models.Place;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
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
