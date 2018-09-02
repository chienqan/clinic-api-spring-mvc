package service;

import exception.EmptyException;
import exception.NullReferenceException;
import model.Drug;
import model.Medicine;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugRepository;
import repository.MedicineRepository;
import repository.PrescriptionRepository;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public List<Drug> getAllDrugs() {
        return (List<Drug>) drugRepository.findAll();
    }

    public List<Drug> getDrugsByPrescriptionId(int prescriptionId) {
        return drugRepository.findDrugsByPrescriptionId(prescriptionId);
    }

    public Drug getDrug(int id) {
        return drugRepository.findOne(id);
    }

    public int saveDrug(Drug drug) {
        Drug item = saveToExistItem(drug);
        return drugRepository.save(item).getId();
    }

    public void updateDrug(Drug drug) {
        Drug item = saveToExistItem(drug);
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

        drugRepository.save(item);
    }

    public void deleteDrug(int id) {
        drugRepository.delete(id);
    }

    private Drug saveToExistItem(Drug drug) {
        String medicineName = drug.getMedicine().getName();

        if(medicineName == null) {
            throw new EmptyException("Drug code should not be empty");
        }

        Medicine medicine = medicineRepository.findOne(medicineName);

        if(medicine == null) {
            throw  new NullReferenceException("Can't not find specific drug with this icd code");
        }

        drug.setMedicine(medicine);

        return drug;
    }
}
