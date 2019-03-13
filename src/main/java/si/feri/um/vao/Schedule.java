package si.feri.um.vao;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSchedule;
    @Column(nullable = false)
    private Long orderBy;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne(targetEntity = Day.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_day", referencedColumnName = "idDay", nullable = false)
    private Day day;
    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "idRestaurant", nullable = false)
    private Restaurant restaurant;

    public Schedule() {
    }

    public Schedule(Long orderBy, LocalTime startTime, LocalTime endTime, Day day, Restaurant restaurant) {
        this.orderBy = orderBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.restaurant = restaurant;
    }

    public Long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
