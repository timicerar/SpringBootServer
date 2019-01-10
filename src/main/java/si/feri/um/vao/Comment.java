package si.feri.um.vao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idComment;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private boolean edited;
    @Column(nullable = false)
    private LocalDateTime timeOfPublication;
    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_restaurant", referencedColumnName = "idRestaurant", nullable = false)
    private Restaurant restaurant;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "idUser", nullable = false)
    private User user;

    public Comment() {
    }

    public Comment(String text, boolean edited, LocalDateTime timeOfPublication, Restaurant restaurant, User user) {
        this.text = text;
        this.edited = edited;
        this.timeOfPublication = timeOfPublication;
        this.restaurant = restaurant;
        this.user = user;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
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
