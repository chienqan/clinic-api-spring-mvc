package model;

import java.util.List;

public class DrugReport {

    private String timeInterval;

    public DrugReport(String timeInterval, List<PrescribedDrug> prescribedDrugs) {
        this.timeInterval = timeInterval;
        this.prescribedDrugs = prescribedDrugs;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public List<PrescribedDrug> getPrescribedDrugs() {
        return prescribedDrugs;
    }

    public void setPrescribedDrugs(List<PrescribedDrug> prescribedDrugs) {
        this.prescribedDrugs = prescribedDrugs;
    }

    private List<PrescribedDrug> prescribedDrugs;
}
