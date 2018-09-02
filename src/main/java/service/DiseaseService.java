package service;

import exception.EmptyException;
import exception.NullReferenceException;
import model.Disease;
import model.Icd;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DiseaseRepository;
import repository.IcdRepository;
import repository.PrescriptionRepository;

import java.util.List;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private IcdRepository icdRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public List<Disease> getAllDiseases() {
        return (List<Disease>) diseaseRepository.findAll();
    }

    public List<Disease> getDiseasesByPrescriptionId(int prescriptionId) {
        return diseaseRepository.findDiseasesByPrescriptionId(prescriptionId);
    }

    public Disease getDisease(int id) {
        return diseaseRepository.findOne(id);
    }

    public int saveDisease(Disease disease) {
        Disease item = saveToExistItem(disease);
        return diseaseRepository.save(item).getId();
    }

    public void updateDisease(Disease disease) {
        Disease item = saveToExistItem(disease);
        Prescription prescription = item.getPrescription();

        int prescriptionId = prescription.getId();

        if(prescriptionId > 0) {
            prescription = prescriptionRepository.findOne(prescriptionId);
        } else {
            throw new EmptyException("Prescription ID is required");
        }

        if(prescription == null) {
            throw new NullReferenceException("Could not found this prescription");
        }

        item.setPrescription(prescription);

        diseaseRepository.save(item);
    }

    public void deleteDisease(int id) {
        diseaseRepository.delete(id);
    }

    private Disease saveToExistItem(Disease disease) {
        String diseaseCode = disease.getIcd().getDiseaseCode();

        if(diseaseCode == null) {
            throw new EmptyException("Disease code should not be empty");
        }

        Icd icd = icdRepository.findOne(diseaseCode);

        if(icd == null) {
            throw  new NullReferenceException("Can't not find specific disease with this icd code");
        }

        disease.setIcd(icd);

        return disease;
    }
}
