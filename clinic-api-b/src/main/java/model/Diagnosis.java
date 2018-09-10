package model;


import javax.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "visitId", nullable = false)
    private Visit visit;

    @ManyToOne
    @JoinColumn(name = "icd", nullable = false)
    private Disease disease;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }


}
