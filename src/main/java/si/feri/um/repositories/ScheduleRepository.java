package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.models.Schedule;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    List<Schedule> getSchedulesByRestaurantIdRestaurant(int idRestaurant);
}
