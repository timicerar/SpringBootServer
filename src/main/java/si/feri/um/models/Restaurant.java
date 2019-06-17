package si.feri.um.models;

import javax.persistence.*;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRestaurant;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Lob
    private String description;
    @Column(nullable = false)
    @Lob
    private String photoUrl;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private double currentRating;
    @Column(nullable = false)
    private String type;

    public Restaurant() {
    }

    public Restaurant(String name, String description, String photoUrl, String address, double latitude, double longitude, double currentRating, String type) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.currentRating = currentRating;
        this.type = type;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getCurrentRating() {
        return currentRating;
    }

    public void setCurrentRating(double currentRating) {
        this.currentRating = currentRating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
