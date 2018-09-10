package service;

import model.Disease;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DiseaseService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String addDisease(Disease disease){

        sessionFactory.getCurrentSession().save(disease);
        return disease.getIcd();
    }

    public void updateDisease(Disease disease){
        sessionFactory.getCurrentSession().update(disease);
    }

    public void deleteDisease(int  diseaseId){
        Disease disease = getDisease(diseaseId);
        sessionFactory.getCurrentSession().delete(disease);

    }

    public List<Disease> getAllDiagnoses(){
        return sessionFactory.getCurrentSession().createQuery("from Disease").list();
    }

    public Disease getDisease(int diseaseId){
        return (Disease) sessionFactory.getCurrentSession().get(Disease.class, diseaseId);

    }
}
