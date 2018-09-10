package model;

import java.util.Date;

public class PrescribedDrug {

    private Drug drug;
    private int prescribeTime;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getPrescribeTime() {
        return prescribeTime;
    }

    public void setPrescribeTime(int prescribeTime) {
        this.prescribeTime = prescribeTime;
    }

    public PrescribedDrug(Drug drug, int prescribeTime) {
        this.drug = drug;
        this.prescribeTime = prescribeTime;
    }
}
