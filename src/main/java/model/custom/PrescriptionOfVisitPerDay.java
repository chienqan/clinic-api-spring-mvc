package model.custom;

public class PrescriptionOfVisitPerDay {
    private int prescriptionId;
    private String date;

    public PrescriptionOfVisitPerDay(int prescriptionId, String date) {
        this.prescriptionId = prescriptionId;
        this.date = date;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
