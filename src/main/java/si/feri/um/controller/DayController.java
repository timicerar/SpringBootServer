package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import si.feri.um.repositories.DayRepository;
import si.feri.um.vao.Day;

@Controller
@RequestMapping(path = "/day")
public class DayController {

    private DayRepository dayRepository;

    @Autowired
    public DayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Day> getAllDays() {
        return dayRepository.findAll();
    }
}
