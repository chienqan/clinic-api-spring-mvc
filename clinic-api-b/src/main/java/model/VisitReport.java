package model;

public class VisitReport {

    private String date;
    private int visits;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public VisitReport(String date, int visits) {
        this.date = date;
        this.visits = visits;
    }
}
