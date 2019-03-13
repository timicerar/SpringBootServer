package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.RatingRepository;
import si.feri.um.vao.Rating;

import java.util.List;

@RestController
@RequestMapping(path = "/rating")
public class RatingController {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping(path = "/all")
    public List<Rating> getAllRatings() {
        return (List<Rating>) ratingRepository.findAll();
    }

    @GetMapping(path = "/{idRating}")
    public Rating getRatingById(@PathVariable Long idRating) {
        if (ratingRepository.existsById(idRating.intValue())) {
            //noinspection OptionalGetWithoutIsPresent
            return ratingRepository.findById(idRating.intValue()).get();
        } else
            return null;
    }

    @GetMapping(path = "/restaurant/{idRestaurant}")
    public List<Rating> getRatingsByRestaurantId(@PathVariable Long idRestaurant) {
        return ratingRepository.getRatingsByRestaurantIdRestaurant(idRestaurant);
    }

    @GetMapping(path = "/user/{idUser}")
    public List<Rating> getRatingsByUserId(@PathVariable Long idUser) {
        return ratingRepository.getRatingsByUserIdUser(idUser);
    }

    @GetMapping(path = "/user/googleId/{googleUserId}")
    public List<Rating> getRatingsByUserGoogleId(@PathVariable String googleUserId) {
        return ratingRepository.getRatingsByUser_GoogleUserId(googleUserId);
    }

    @PostMapping(path = "/add")
    public Rating addNewRating(@RequestBody Rating rating) {
        return ratingRepository.save(rating);
    }

    @PutMapping(path = "update/{idRating}")
    public Rating updateRating(@RequestBody Rating newRatingData, @PathVariable Long idRating) {
        return ratingRepository.findById(idRating.intValue())
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
    public boolean deleteRating(@PathVariable Long idRating) {
        if (ratingRepository.existsById(idRating.intValue())) {
            ratingRepository.deleteById(idRating.intValue());
            return true;
        } else
            return false;
    }
}
