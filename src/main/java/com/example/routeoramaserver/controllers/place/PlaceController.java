package com.example.routeoramaserver.controllers.place;

import com.example.routeoramaserver.controllers.place.rmi.IPlaceClient;
import com.example.routeoramaserver.controllers.place.rmi.PlaceClient;
import com.example.routeoramaserver.models.Place;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class PlaceController {
    private IPlaceClient placeClient;

    public PlaceController() {
        placeClient = new PlaceClient();
        placeClient.Start();
    }

    @PostMapping(value = "/place", consumes = "application/json", produces = "application/json")
    public Place NewPlace(@RequestBody Place place) {
        return placeClient.NewPlace(place);
    }

    @GetMapping(value = "/place/{name}", produces = "application/json")
    public Place GetPlace(@PathVariable("name") String name) {
        return placeClient.GetPlace(name);
    }

    @GetMapping(value = "/place?lat={lat}&lng={lng}", produces = "application/json")
    public Place GetPlace(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng) {
        return placeClient.GetPlace(lat, lng);
    }

    /*
    Method for fetching a list of places within bounds (for the markers on the client side).
     */

    @PostMapping(value = "/place/bounds", consumes = "application/json", produces = "application/json")
    public List<Place> GetPlacesInBounds(@RequestBody List<Double> bounds) {
        return placeClient.GetPlacesInBounds(bounds);
    }

    @PostMapping(value = "/place/follow", consumes = "application/json", produces = "application/json")
    public void FollowThePlace(@RequestBody int[] array) {
        placeClient.FollowThePlace(array[0], array[1]);
    }

    @PostMapping(value = "/place/unfollow", consumes = "application/json")
    public void UnfollowThePlace(@RequestBody int[] array) {
        placeClient.UnfollowThePlace(array[0], array[1]);
    }

    @PostMapping(value = "/place/isfollowed",consumes = "application/json", produces = "application/json")
    public boolean IsAlreadyFollowed(@RequestBody int[] array) {
        return placeClient.IsAlreadyFollowed(array[0], array[1]);
    }

    @PostMapping(value = "/place/getmostfollowed", produces = "application/json")
    public List<String> GetMostFollowedPlaces(){
        return placeClient.GetMostFollowedPlaces();
    }

    @PostMapping(value = "/place/getmostliked", produces = "application/json")
    public List<String> GetMostLikedPlaces(){
        return placeClient.GetMostLikedPlaces();
    }

    @PostMapping(value = "/place/search", produces = "application/json", consumes = "application/json")
    public List<Place> SearchForPlace(@RequestBody String name){
        return placeClient.SearchForPlace(name);
    }
}
