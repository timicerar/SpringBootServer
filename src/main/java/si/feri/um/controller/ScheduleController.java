package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import si.feri.um.repositories.ScheduleRepository;
import si.feri.um.vao.Schedule;

@Controller
@RequestMapping(path = "/schedule")
public class ScheduleController {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }
}
