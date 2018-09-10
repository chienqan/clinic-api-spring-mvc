package service;

import model.Patient;
import model.Visit;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PatientService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int addPatient(Patient patient){
        //assign patient to visits:

        try{
            for (Visit visit: patient.getVisits()){
                visit.setPatient(patient);
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }


        sessionFactory.getCurrentSession().save(patient);
        return patient.getId();
    }

    public void updatePatient(Patient patient){
        sessionFactory.getCurrentSession().update(patient);
    }

    public void deletePatient(int  patientId){
        Patient patient = getPatient(patientId);
        sessionFactory.getCurrentSession().delete(patient);

    }

    public List<Patient> getAllPatients(){
        return sessionFactory.getCurrentSession().createQuery("from Patient").list();
    }

    public Patient getPatient(int patientId){

        return (Patient) sessionFactory.getCurrentSession().get(Patient.class, patientId);

    }

    public List<Patient> findPatientByName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient p where p.name like:name");

        query.setString("name", "%"+name+"%");

        return query.list();
    }

    public List<Patient> findPatientByBirthdate(String birthdate){

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        List<Patient> allPatients = getAllPatients();
        List<Patient> results = new ArrayList<>();

        for(Patient patient:allPatients){
            String d = df.format(patient.getBirthdate());
            if (d.contains(birthdate)){
                results.add(patient);
            }
        }

        return results;
    }
}
