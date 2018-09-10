package service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import model.DrugReport;
import model.PrescribedDrug;
import model.PrescriptionDetail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class PrescriptionDetailService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPrescriptionDetail(PrescriptionDetail prescriptionDetail){

        sessionFactory.getCurrentSession().save(prescriptionDetail);
        return prescriptionDetail.getId();
    }

    public void updatePrescriptionDetail(PrescriptionDetail prescriptionDetail){
        sessionFactory.getCurrentSession().update(prescriptionDetail);
    }

    public void deletePrescriptionDetail(int  prescriptionDetailId){
        PrescriptionDetail prescriptionDetail = getPrescriptionDetail(prescriptionDetailId);
        sessionFactory.getCurrentSession().delete(prescriptionDetail);

    }

    public List<PrescriptionDetail> getAllPrescriptionDetails(){
        return sessionFactory.getCurrentSession().createQuery("from PrescriptionDetail").list();
    }

    public PrescriptionDetail getPrescriptionDetail(int prescriptionDetailId){
        return (PrescriptionDetail) sessionFactory.getCurrentSession().get(PrescriptionDetail.class, prescriptionDetailId);
    }

    public List<PrescriptionDetail> getDetailsByPrescription(int prescriptionId){

        List<PrescriptionDetail> allPrescriptionDetails = getAllPrescriptionDetails();
        List<PrescriptionDetail> result = new ArrayList<>();
        for(PrescriptionDetail prescriptionDetail:allPrescriptionDetails){
            if(prescriptionDetail.getPrescription().getId() == (prescriptionId)){
                result.add(prescriptionDetail);
            }
        }
        return result;
    }

    public DrugReport countDrugPrescribed(){

        try{

            List<PrescriptionDetail> allPrescriptionDetails = getAllPrescriptionDetails();
            List<PrescribedDrug> allPrescribedDrugs = new ArrayList<>();

            for(PrescriptionDetail prescriptionDetail: allPrescriptionDetails){
                boolean drugCheck = true;
                int foundDrug = 0;
                for(PrescribedDrug prescribedDrug: allPrescribedDrugs){
                    if(prescribedDrug.getDrug().equals(prescriptionDetail.getDrug())){
                       drugCheck = false;
                       foundDrug = allPrescribedDrugs.indexOf(prescribedDrug);
                    }
                }
                if (drugCheck){
                    allPrescribedDrugs.add(new PrescribedDrug(prescriptionDetail.getDrug(), 1));
                } else {
                    allPrescribedDrugs.get(foundDrug).setPrescribeTime(allPrescribedDrugs.get(foundDrug).getPrescribeTime()+1);
                }
            }

            Date max = allPrescriptionDetails.get(0).getPrescription().getVisit().getVisitTime();

            for (int i = 0; i < allPrescriptionDetails.size(); i++){
                if (allPrescriptionDetails.get(i).getPrescription().getVisit().getVisitTime().after(max)){
                    max = allPrescriptionDetails.get(i).getPrescription().getVisit().getVisitTime();
                }
            }
            Date min = allPrescriptionDetails.get(0).getPrescription().getVisit().getVisitTime();

            for (int i = 0; i < allPrescriptionDetails.size(); i++){
                if (allPrescriptionDetails.get(i).getPrescription().getVisit().getVisitTime().before(min)){
                    min = allPrescriptionDetails.get(i).getPrescription().getVisit().getVisitTime();
                }
            }

            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

            String time = "From " + df.format(min) + " to " + df.format(max);

            return new DrugReport(time,allPrescribedDrugs);

        } catch (Exception e){
            return null;
        }
    }

}
