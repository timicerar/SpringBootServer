package si.feri.um.vao;

import javax.persistence.*;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDay;
    @Column(nullable = false)
    private String name;

    public Day() {
    }

    public Day(String name) {
        this.name = name;
    }

    public Long getIdDay() {
        return idDay;
    }

    public void setIdDay(Long idDay) {
        this.idDay = idDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
