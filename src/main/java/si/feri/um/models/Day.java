package si.feri.um.models;

import javax.persistence.*;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDay;
    @Column(nullable = false)
    private String name;

    public Day() {
    }

    public Day(String name) {
        this.name = name;
    }

    public int getIdDay() {
        return idDay;
    }

    public void setIdDay(int idDay) {
        this.idDay = idDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
