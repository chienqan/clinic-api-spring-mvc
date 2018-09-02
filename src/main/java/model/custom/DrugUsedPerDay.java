package model.custom;

import model.Drug;

import java.util.List;

public class DrugUsedPerDay {
    private String date;
    private List<Drug> drug;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Drug> getDrug() {
        return drug;
    }

    public void setDrug(List<Drug> drug) {
        this.drug = drug;
    }
}
