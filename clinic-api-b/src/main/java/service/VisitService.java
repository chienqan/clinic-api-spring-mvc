package service;

import com.google.gson.Gson;
import model.Diagnosis;
import model.Visit;
import model.VisitReport;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class VisitService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addVisit(Visit visit){

        try{

            for (Diagnosis diagnosis: visit.getDiagnosis()){
                diagnosis.setVisit(visit);
            }

        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        sessionFactory.getCurrentSession().save(visit);
        return visit.getId();
    }

    public void updateVisit(Visit visit){
        sessionFactory.getCurrentSession().update(visit);
    }

    public void deleteVisit(int  visitId){
        Visit visit = getVisit(visitId);
        sessionFactory.getCurrentSession().delete(visit);

    }

    public List<Visit> getAllVisits(){
        return sessionFactory.getCurrentSession().createQuery("from Visit").list();
    }

    public Visit getVisit(int visitId){
        return (Visit) sessionFactory.getCurrentSession().get(Visit.class, visitId);

    }

    public List<Visit> findVisitByDate(String date) {

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        List<Visit> allVisits = getAllVisits();
        List<Visit> results = new ArrayList<>();

        for(Visit visit:allVisits){
            String d = df.format(visit.getVisitTime());
            if (d.contains(date)){
                results.add(visit);
            }
        }

        return results;
    }

    public List<Visit> findVisitByPatient(int patientId){

        List<Visit> allVisits = getAllVisits();
        List<Visit> queryVisits = new ArrayList<>();
        for(Visit visit: allVisits){
            if(visit.getPatient().getId() == patientId){
                queryVisits.add(visit);
            }
        }

        try{
            return queryVisits;
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }


    public List<VisitReport> countVisitPerDay(){

        try{

            List<Visit> allVisits = getAllVisits();
            List<VisitReport> visitReports = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            for(Visit visit:allVisits){
                boolean visitCheck = true;
                int foundVisit = 0;
                for(VisitReport visitReport:visitReports){
                    if((visitReport.getDate()).equals(df.format(visit.getVisitTime()))){
                        visitCheck = false;
                        foundVisit = visitReports.indexOf(visitReport);
                    }
                }

                if (visitCheck){
                    visitReports.add(new VisitReport(df.format(visit.getVisitTime()), 1));
                } else {
                    visitReports.get(foundVisit).setVisits(visitReports.get(foundVisit).getVisits()+1);
                }
            }

        return visitReports;
        } catch (Exception e){
            return null;
        }
    }
}
