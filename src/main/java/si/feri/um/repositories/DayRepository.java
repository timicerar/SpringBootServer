package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.models.Day;

public interface DayRepository extends CrudRepository<Day, Integer> {
}
