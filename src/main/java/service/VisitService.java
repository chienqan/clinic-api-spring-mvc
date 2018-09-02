package service;

import exception.NullReferenceException;
import model.*;
import model.custom.DrugUsedPerDay;
import model.custom.PrescriptionOfVisitPerDay;
import model.custom.PatientOfVisitPerDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugRepository;
import repository.PatientRepository;
import repository.PrescriptionRepository;
import repository.VisitRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VisitService {
    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DrugRepository drugRepository;

    public List<Visit> getAllVisits() {
        return (List<Visit>) visitRepository.findAll();
    }

    public List<PatientOfVisitPerDay> getNumberOfPatientVisitsPerDay() {
        return visitRepository.findNumberOfPatientVisitsPerDay();
    }

    public List<DrugUsedPerDay> getNumberOfDrugUsedPerDay() {

        List<DrugUsedPerDay> drugUsedPerDays = new ArrayList<>();
        for(PrescriptionOfVisitPerDay prescriptionOfVisitPerDay: visitRepository.findNumberOfDrugUsedPerDay()) {
            int prescriptionId = prescriptionOfVisitPerDay.getPrescriptionId();
            DrugUsedPerDay drugUsedPerDay = new DrugUsedPerDay();
            drugUsedPerDay.setDate(prescriptionOfVisitPerDay.getDate());
            drugUsedPerDay.setDrug(drugRepository.findDrugsByPrescriptionId(prescriptionId));
            drugUsedPerDays.add(drugUsedPerDay);
        }

        return drugUsedPerDays;
    }

    public List<Visit> getVisitsByDate(String date) {
        return visitRepository.findVisitsByDate(date);
    }

    public List<Visit> getVisitsByPatientId(int id) {
        return visitRepository.findVisitsByPatientId(id);
    }

    public Visit getVisit(int id) {
        return visitRepository.findOne(id);
    }

    public int saveVisit(Visit visit) {
        Visit item = saveToExistItem(visit);
        return visitRepository.save(item).getId();
    }

    public void updateVisit(Visit visit) {
        Visit item = saveToExistItem(visit);
        visitRepository.save(item);
    }

    public void deleteVisit(int id) {
        visitRepository.delete(id);
    }

    private Visit saveToExistItem(Visit visit) {

        Prescription prescription = visit.getPrescription();

        int prescriptionId = prescription.getId();

        if(prescriptionId > 0) {
             prescription = prescriptionRepository.findOne(prescriptionId);
        }

        if(prescription == null) {
            throw new NullReferenceException("Prescription is required, or ensure this prescription ID is exists");
        }

        visit.setPrescription(prescription);

        Patient patient = visit.getPatient();

        int patientId = patient.getId();

        if(patientId > 0) {
            patient = patientRepository.findOne(patientId);
        }

        if(patient == null) {
            throw new NullReferenceException("Patient is required or ensure this patient ID is exists");
        }

        visit.setPatient(patient);

        return visit;
    }

}
