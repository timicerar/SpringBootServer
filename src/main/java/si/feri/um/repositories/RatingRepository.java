package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Rating;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
    List<Rating> getRatingsByUserIdUser(int idUser);
    List<Rating> getRatingsByUserIdUserAndRestaurantIdRestaurant(int idUser, int idRestaurant);
    List<Rating> getRatingsByRestaurantIdRestaurant(int idRestaurant);
    List<Rating> getRatingsByUser_GoogleUserId(String googleUserId);
    List<Rating> getRatingsByUser_GoogleUserIdAndRestaurantIdRestaurant(String googleUserId, int idRestaurant);
    Rating getRatingByRestaurant_IdRestaurantAndUser_GoogleUserId(int idRestaurant, String googleUserId);
}
