package si.feri.um.repositories;

import org.springframework.data.repository.CrudRepository;
import si.feri.um.vao.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
}
