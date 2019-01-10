package si.feri.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.feri.um.repositories.DayRepository;
import si.feri.um.vao.Day;

import java.util.List;

@RestController
@RequestMapping(path = "/day")
public class DayController {

    private DayRepository dayRepository;

    @Autowired
    public DayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @GetMapping(path = "/all")
    public List<Day> getAllDays() {
        return (List<Day>) dayRepository.findAll();
    }

    @GetMapping(path = "/{idDay}")
    public Day getDay(@PathVariable int idDay) {
        if (dayRepository.existsById(idDay)) {
            //noinspection OptionalGetWithoutIsPresent
            return dayRepository.findById(idDay).get();
        } else
            return null;

    }

    @PostMapping(path = "/add")
    public Day addNewDay(@RequestBody Day day) {
        return dayRepository.save(day);
    }

    @PutMapping(path = "update/{idDay}")
    public Day updateDay(@RequestBody Day newDayData, @PathVariable int idDay) {
        return dayRepository.findById(idDay)
                .map(day -> {
                    day.setName(newDayData.getName());
                    return dayRepository.save(day);
                })
                .orElseGet(() -> {
                    newDayData.setIdDay(idDay);
                    return dayRepository.save(newDayData);
                });
    }

    @DeleteMapping(path = "/delete/{idDay}")
    public void deleteDay(@PathVariable int idDay) {
        dayRepository.deleteById(idDay);
    }
}
