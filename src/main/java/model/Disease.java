package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Icd icd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Prescription prescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Icd getIcd() {
        return icd;
    }

    public void setIcd(Icd icd) {
        this.icd = icd;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
