package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
}
