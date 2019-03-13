package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.RestaurantRepository;
import si.feri.um.vao.Restaurant;

import java.util.List;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping(path = "/all")
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    @GetMapping(path = "/{idRestaurant}")
    public Restaurant getRestaurantById(@PathVariable Long idRestaurant) {
        if (restaurantRepository.existsById(idRestaurant.intValue())) {
            //noinspection OptionalGetWithoutIsPresent
            return restaurantRepository.findById(idRestaurant.intValue()).get();
        } else
            return null;

    }

    @PostMapping(path = "/add")
    public Restaurant addNewRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping(path = "update/{idRestaurant}")
    public Restaurant updateRestaurant(@RequestBody Restaurant newRestaurantData, @PathVariable Long idRestaurant) {
        return restaurantRepository.findById(idRestaurant.intValue())
                .map(restaurant -> {
                    restaurant.setPhotoUrl(newRestaurantData.getPhotoUrl());
                    restaurant.setDescription(newRestaurantData.getDescription());
                    restaurant.setAddress(newRestaurantData.getAddress());
                    restaurant.setCurrentRating(newRestaurantData.getCurrentRating());
                    restaurant.setLatitude(newRestaurantData.getLatitude());
                    restaurant.setLongitude(newRestaurantData.getLongitude());
                    restaurant.setName(newRestaurantData.getName());
                    restaurant.setType(newRestaurantData.getType());
                    return restaurantRepository.save(restaurant);
                })
                .orElseGet(() -> {
                    newRestaurantData.setIdRestaurant(idRestaurant);
                    return restaurantRepository.save(newRestaurantData);
                });
    }

    @DeleteMapping(path = "/delete/{idRestaurant}")
    public boolean deleteRestaurant(@PathVariable Long idRestaurant) {
        if (restaurantRepository.existsById(idRestaurant.intValue())) {
            restaurantRepository.deleteById(idRestaurant.intValue());
            return true;
        } else
            return false;
    }
}
