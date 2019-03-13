package si.feri.um.vao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRating;
    @Column(nullable = false)
    private double value;
    @Column(nullable = false)
    private LocalDateTime timeOfPublication;
    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "idRestaurant", nullable = false)
    private Restaurant restaurant;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "idUser", nullable = false)
    private User user;

    public Rating() {
    }

    public Rating(double value, LocalDateTime timeOfPublication, Restaurant restaurant, User user) {
        this.value = value;
        this.timeOfPublication = timeOfPublication;
        this.restaurant = restaurant;
        this.user = user;
    }

    public Long getIdRating() {
        return idRating;
    }

    public void setIdRating(Long idRating) {
        this.idRating = idRating;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTimeOfPublication() {
        return timeOfPublication;
    }

    public void setTimeOfPublication(LocalDateTime timeOfPublication) {
        this.timeOfPublication = timeOfPublication;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
