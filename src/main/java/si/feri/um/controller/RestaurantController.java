package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.RestaurantRepository;
import si.feri.um.vao.Restaurant;
import si.feri.um.vao.User;

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
    public Restaurant getRestaurant(@PathVariable int idRestaurant) {
        if (restaurantRepository.existsById(idRestaurant)) {
            //noinspection OptionalGetWithoutIsPresent
            return restaurantRepository.findById(idRestaurant).get();
        } else
            return null;

    }

    @PostMapping(path = "/add")
    public Restaurant addNewRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping(path = "update/{idRestaurant}")
    public Restaurant updateRestaurant(@RequestBody Restaurant newRestaurantData, @PathVariable int idRestaurant) {
        return restaurantRepository.findById(idRestaurant)
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
    public void deleteRestaurant(@PathVariable int idRestaurant) {
        restaurantRepository.deleteById(idRestaurant);
    }
}
