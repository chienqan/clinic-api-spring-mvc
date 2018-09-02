package service;

import exception.EmptyException;
import exception.NullReferenceException;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private IcdRepository icdRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Prescription> getAllPrescriptions() {
        return (List<Prescription>) prescriptionRepository.findAll();
    }

    public Prescription getPrescription(int id) {
        return prescriptionRepository.findOne(id);
    }

    public int savePrescription(Prescription prescription) {
        Prescription item = saveToExistItem(prescription);
        return prescriptionRepository.save(item).getId();
    }

    public void updatePrescription(Prescription prescription) {
        Prescription item = saveToExistItem(prescription);
        prescriptionRepository.save(item);
    }

    public void deletePrescription(int id) {
        prescriptionRepository.delete(id);
    }

    private Prescription saveToExistItem(Prescription prescription) {
        List<Drug> drugs = prescription.getDrugs();

        if(drugs == null) {
            throw new NullReferenceException("Drug should not be null");
        }

        if(drugs.isEmpty()) {
            throw new EmptyException("Drug should not be empty");
        }

        for(Drug drug: drugs) {
            String medicineName = drug.getMedicine().getName();

            if(medicineName == null) {
                throw new EmptyException("Disease code should not be empty");
            }

            Medicine medicine = medicineRepository.findOne(medicineName);

            if(medicine == null) {
                throw  new NullReferenceException("Can't not find specific disease with this icd code");
            }

            drug.setMedicine(medicine);
            drug.setPrescription(prescription);
        }

        List<Disease> diseases = prescription.getDiseases();

        if(diseases == null) {
            throw new NullReferenceException("Disease should not be null");
        }

        if(diseases.isEmpty()) {
            throw new EmptyException("Disease should not be empty");
        }

        for(Disease disease: prescription.getDiseases()) {
            String diseaseCode = disease.getIcd().getDiseaseCode();

            if(diseaseCode == null) {
                throw new EmptyException("Disease code should not be empty");
            }

            Icd icd = icdRepository.findOne(diseaseCode);

            if(icd == null) {
                throw  new NullReferenceException("Can't not find specific disease with this icd code");
            }

            disease.setIcd(icd);
            disease.setPrescription(prescription);
        }
        return prescription;
    }
}
