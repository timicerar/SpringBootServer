package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import si.feri.um.repositories.RatingRepository;
import si.feri.um.vao.Rating;

@Controller
@RequestMapping(path = "/rating")
public class RatingController {

    private RatingRepository ratingRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
