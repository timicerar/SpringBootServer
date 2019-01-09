package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Rating;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
