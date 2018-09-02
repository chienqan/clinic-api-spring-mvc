package model.custom;

public class PatientOfVisitPerDay {
    private long numberOfPatient;
    private String date;

    public PatientOfVisitPerDay(long numberOfPatient, String date) {
        this.numberOfPatient = numberOfPatient;
        this.date = date;
    }

    public long getNumberOfPatient() {
        return numberOfPatient;
    }

    public void setNumberOfPatient(long numberOfPatient) {
        this.numberOfPatient = numberOfPatient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
