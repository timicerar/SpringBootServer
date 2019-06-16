package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.RatingRepository;
import si.feri.um.repositories.RestaurantRepository;
import si.feri.um.vao.Rating;
import si.feri.um.vao.Restaurant;

import java.util.List;

@RestController
@RequestMapping(path = "/rating")
public class RatingController {

    private RatingRepository ratingRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository, RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.ratingRepository = ratingRepository;
    }

    @GetMapping(path = "/all")
    public List<Rating> getAllRatings() {
        return (List<Rating>) ratingRepository.findAll();
    }

    @GetMapping(path = "/{idRating}")
    public Rating getRatingById(@PathVariable int idRating) {
        if (ratingRepository.existsById(idRating)) {
            //noinspection OptionalGetWithoutIsPresent
            return ratingRepository.findById(idRating).get();
        } else
            return null;
    }

    @GetMapping(path = "/restaurant/{idRestaurant}/user/googleId/{userGoogleId}")
    public Boolean getRatingByRestaurantIdRestaurantAndUserGoogleUserId(@PathVariable int idRestaurant, @PathVariable String userGoogleId) {
        return ratingRepository.getRatingByRestaurant_IdRestaurantAndUser_GoogleUserId(idRestaurant, userGoogleId) != null;
    }

    @GetMapping(path = "/restaurant/{idRestaurant}")
    public List<Rating> getRatingsByRestaurantId(@PathVariable int idRestaurant) {
        return ratingRepository.getRatingsByRestaurantIdRestaurant(idRestaurant);
    }

    @GetMapping(path = "/user/{idUser}")
    public List<Rating> getRatingsByUserId(@PathVariable int idUser) {
        return ratingRepository.getRatingsByUserIdUser(idUser);
    }

    @GetMapping(path = "/user/googleId/{googleUserId}")
    public List<Rating> getRatingsByUserGoogleId(@PathVariable String googleUserId) {
        return ratingRepository.getRatingsByUser_GoogleUserId(googleUserId);
    }

    @GetMapping(path = "/user/googleId/{googleUserId}/restaurant/{restaurantId}")
    public List<Rating> getRatingsByUserGoogleIdAndGoogleId(@PathVariable String googleUserId, @PathVariable int restaurantId) {
        return ratingRepository.getRatingsByUser_GoogleUserIdAndRestaurantIdRestaurant(googleUserId, restaurantId);
    }

    @PostMapping(path = "/add")
    public Rating addNewRating(@RequestBody Rating rating) {
        List<Rating> usersRatings =
                ratingRepository.getRatingsByUserIdUserAndRestaurantIdRestaurant(
                        rating.getUser().getIdUser(),
                        rating.getRestaurant().getIdRestaurant()
                );

        Rating createdRating = ratingRepository.save(rating);

        if (usersRatings != null) {
            if (usersRatings.size() == 0) {
                Restaurant restaurant = restaurantRepository.getRestaurantByIdRestaurant(rating.getRestaurant().getIdRestaurant());
                double newRatingValue = (restaurant.getCurrentRating() + rating.getValue()) / 2;

                if (newRatingValue > 5)
                    restaurant.setCurrentRating(5);
                else
                    restaurant.setCurrentRating(newRatingValue);

                restaurantRepository.save(restaurant);
            }
        }

        return createdRating;
    }

    @PutMapping(path = "update/{idRating}")
    public Rating updateRating(@RequestBody Rating newRatingData, @PathVariable int idRating) {
        return ratingRepository.findById(idRating)
                .map(rating -> {
                    rating.setRestaurant(newRatingData.getRestaurant());
                    rating.setUser(newRatingData.getUser());
                    rating.setTimeOfPublication(newRatingData.getTimeOfPublication());
                    rating.setValue(newRatingData.getValue());
                    return ratingRepository.save(rating);
                })
                .orElseGet(() -> {
                    newRatingData.setIdRating(idRating);
                    return ratingRepository.save(newRatingData);
                });
    }

    @DeleteMapping(path = "/delete/{idRating}")
    public boolean deleteRating(@PathVariable int idRating) {
        if (ratingRepository.existsById(idRating)) {
            ratingRepository.deleteById(idRating);
            return true;
        } else
            return false;
    }
}
