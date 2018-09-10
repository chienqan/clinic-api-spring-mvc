package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "visitId", unique = true)
    private Visit visit;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PrescriptionDetail> prescriptionDetail;

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

    public List<PrescriptionDetail> getPrescriptionDetail() {
        return prescriptionDetail;
    }

    public void setPrescriptionDetail(List<PrescriptionDetail> prescriptionDetail) {
        this.prescriptionDetail = prescriptionDetail;
    }
}
