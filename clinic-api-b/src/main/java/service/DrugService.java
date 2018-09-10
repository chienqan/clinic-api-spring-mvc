package service;

import model.Drug;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DrugService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addDrug(Drug drug){

        sessionFactory.getCurrentSession().save(drug);
        return drug.getId();
    }

    public void updateDrug(Drug drug){
        sessionFactory.getCurrentSession().update(drug);
    }

    public void deleteDrug(int  drugId){
        Drug drug = getDrug(drugId);
        sessionFactory.getCurrentSession().delete(drug);

    }

    public List<Drug> getAllDrugs(){
        return sessionFactory.getCurrentSession().createQuery("from Drug").list();
    }

    public Drug getDrug(int drugId){
        return (Drug) sessionFactory.getCurrentSession().get(Drug.class, drugId);

    }
}
