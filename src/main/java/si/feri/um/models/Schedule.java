package si.feri.um.models;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSchedule;
    @Column(nullable = false)
    private int orderBy;
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

    public Schedule(int orderBy, LocalTime startTime, LocalTime endTime, Day day, Restaurant restaurant) {
        this.orderBy = orderBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
        this.restaurant = restaurant;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
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
