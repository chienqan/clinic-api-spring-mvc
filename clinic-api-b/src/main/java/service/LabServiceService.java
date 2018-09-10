package service;

import model.LabService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LabServiceService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addLabService(LabService labService){

        sessionFactory.getCurrentSession().save(labService);
        return labService.getId();
    }

    public void updateLabService(LabService labService){
        sessionFactory.getCurrentSession().update(labService);
    }

    public void deleteLabService(int  labServiceId){
        LabService labService = getLabService(labServiceId);
        sessionFactory.getCurrentSession().delete(labService);

    }

    public List<LabService> getAllDiagnoses(){
        return sessionFactory.getCurrentSession().createQuery("from LabService").list();
    }

    public LabService getLabService(int labServiceId){
        return (LabService) sessionFactory.getCurrentSession().get(LabService.class, labServiceId);

    }
}
