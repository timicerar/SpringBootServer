package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Rating;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
    List<Rating> getRatingsByUserIdUser(Long idUser);
    List<Rating> getRatingsByRestaurantIdRestaurant(Long idRestaurant);
    List<Rating> getRatingsByUser_GoogleUserId(String googleUserId);
}
