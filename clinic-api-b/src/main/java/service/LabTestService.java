package service;

import model.LabTest;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LabTestService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addLabTest(LabTest labTest){

        sessionFactory.getCurrentSession().save(labTest);
        return labTest.getId();
    }

    public void updateLabTest(LabTest labTest){
        sessionFactory.getCurrentSession().update(labTest);
    }

    public void deleteLabTest(int  labTestId){
        LabTest labTest = getLabTest(labTestId);
        sessionFactory.getCurrentSession().delete(labTest);

    }

    public List<LabTest> getAllDiagnoses(){
        return sessionFactory.getCurrentSession().createQuery("from LabTest").list();
    }

    public LabTest getLabTest(int labTestId){
        return (LabTest) sessionFactory.getCurrentSession().get(LabTest.class, labTestId);

    }
}
