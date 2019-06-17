package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.ScheduleRepository;
import si.feri.um.models.Schedule;

import java.util.List;

@RestController
@RequestMapping(path = "/schedule")
public class ScheduleController {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping(path = "/all")
    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @GetMapping(path = "/restaurant/{idRestaurant}")
    public List<Schedule> getSchedulesByRestaurantId(@PathVariable int idRestaurant) {
        return scheduleRepository.getSchedulesByRestaurantIdRestaurant(idRestaurant);
    }

    @PostMapping(path = "/add")
    public Schedule addNewSchedule(@RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @PutMapping(path = "update/{idSchedule}")
    public Schedule updateSchedule(@RequestBody Schedule newScheduleData, @PathVariable int idSchedule) {
        return scheduleRepository.findById(idSchedule)
                .map(schedule -> {
                    schedule.setOrderBy(newScheduleData.getOrderBy());
                    schedule.setStartTime(newScheduleData.getStartTime());
                    schedule.setEndTime(newScheduleData.getEndTime());
                    schedule.setDay(newScheduleData.getDay());
                    schedule.setRestaurant(newScheduleData.getRestaurant());
                    return scheduleRepository.save(schedule);
                })
                .orElseGet(() -> {
                    newScheduleData.setIdSchedule(idSchedule);
                    return scheduleRepository.save(newScheduleData);
                });
    }

    @DeleteMapping(path = "/delete/{idSchedule}")
    public boolean deleteSchedule(@PathVariable int idSchedule) {
        if (scheduleRepository.existsById(idSchedule)){
            scheduleRepository.deleteById(idSchedule);
            return true;
        } else
            return false;
    }
}
