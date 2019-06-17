package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    Restaurant getRestaurantByIdRestaurant(int idRestaurant);
}
