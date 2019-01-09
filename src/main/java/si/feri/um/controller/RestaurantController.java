package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import si.feri.um.repositories.RestaurantRepository;
import si.feri.um.vao.Restaurant;

@Controller
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
