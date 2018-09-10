package service;


import model.Prescription;
import model.PrescriptionDetail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;


@Service
@Transactional
public class PrescriptionService{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPrescription(Prescription prescription){

        prescription.getVisit().setPrescription(prescription);

        try{
            for (PrescriptionDetail prescriptionDetail: prescription.getPrescriptionDetail()){
                prescriptionDetail.setPrescription(prescription);
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        sessionFactory.getCurrentSession().save(prescription);
        return prescription.getId();
    }

    public void updatePrescription(Prescription prescription){
        sessionFactory.getCurrentSession().update(prescription);
    }

    public void deletePrescription(int  prescriptionId){

        Prescription prescription = getPrescription(prescriptionId);
        prescription.getVisit().setPrescription(null);
        sessionFactory.getCurrentSession().delete(prescription);

    }

    public List<Prescription> getAllPrescriptions(){
        return sessionFactory.getCurrentSession().createQuery("from Prescription").list();
    }

    public Prescription getPrescription(int prescriptionId){
        return (Prescription) sessionFactory.getCurrentSession().get(Prescription.class, prescriptionId);
    }

    public List<PrescriptionDetail> getPrescriptionDetails(int prescriptionId){

        Prescription prescription = getPrescription(prescriptionId);
        PrescriptionDetailService prescriptionDetailService = new PrescriptionDetailService();
        List<PrescriptionDetail> allPrescriptionDetails = prescriptionDetailService.getAllPrescriptionDetails();
        List<PrescriptionDetail> result = new ArrayList<>();
        for (PrescriptionDetail prescriptionDetail:allPrescriptionDetails){
            if(prescriptionDetail.getPrescription().equals(prescription)){
                result.add(prescriptionDetail);
            }
        }
        return result;
    }


}
