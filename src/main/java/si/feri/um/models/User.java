package si.feri.um.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;
    @Column(nullable = false)
    private String googleUserId;
    @Column(nullable = false)
    private String nameSurname;
    private LocalDate birthday;
    private String gender;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String photoUrl;

    public User() {
    }

    public User(String googleUserId, String nameSurname, LocalDate birthday, String gender, String email, String photoUrl) {
        this.googleUserId = googleUserId;
        this.nameSurname = nameSurname;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.photoUrl = photoUrl;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        this.googleUserId = googleUserId;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String name) {
        this.nameSurname = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
