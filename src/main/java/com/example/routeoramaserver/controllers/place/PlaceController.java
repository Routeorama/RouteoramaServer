package com.example.routeoramaserver.controllers.place;

import com.example.routeoramaserver.controllers.place.rmi.IPlaceClient;
import com.example.routeoramaserver.controllers.place.rmi.PlaceClient;
import com.example.routeoramaserver.models.Location;
import com.example.routeoramaserver.models.Place;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping(value = "/place/{name}", produces = "application/json")
    public Place GetPlace(@PathVariable("name") String name){
        return placeClient.GetPlace(name);
    }

    @GetMapping(value = "/place?lat={lat}&lng={lng}", produces = "application/json")
    public Place GetPlace(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng){
        return placeClient.GetPlace(lat, lng);
    }

}
