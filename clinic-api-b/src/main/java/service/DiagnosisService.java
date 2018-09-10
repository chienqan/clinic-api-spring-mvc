package service;

import model.Diagnosis;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DiagnosisService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addDiagnosis(Diagnosis diagnosis){

        sessionFactory.getCurrentSession().save(diagnosis);
        return diagnosis.getId();
    }

    public void updateDiagnosis(Diagnosis diagnosis){
        sessionFactory.getCurrentSession().update(diagnosis);
    }

    public void deleteDiagnosis(int  diagnosisId){
        Diagnosis diagnosis = getDiagnosis(diagnosisId);
        sessionFactory.getCurrentSession().delete(diagnosis);

    }

    public List<Diagnosis> getAllDiagnoses(){
        return sessionFactory.getCurrentSession().createQuery("from Diagnosis").list();
    }

    public Diagnosis getDiagnosis(int diagnosisId){
        return (Diagnosis) sessionFactory.getCurrentSession().get(Diagnosis.class, diagnosisId);

    }

    public List<Diagnosis> getDiagnosisByVisit(int visitId){

        List<Diagnosis> allDiagnoses = getAllDiagnoses();
        List<Diagnosis> result = new ArrayList<>();
        for(Diagnosis diagnosis:allDiagnoses){
            if(diagnosis.getVisit().getId() == (visitId)){
                result.add(diagnosis);
            }
        }

        return result;
    }
}
