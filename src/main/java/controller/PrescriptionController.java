package controller;

import model.Disease;
import model.Drug;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DiseaseService;
import service.DrugService;
import service.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("prescriptions")
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }

    @GetMapping("prescriptions/{id}")
    public Prescription getPrescription(@PathVariable int id) {
        return prescriptionService.getPrescription(id);
    }

    @GetMapping("prescriptions/{id}/drugs")
    public List<Drug> getPrescriptionDrugs(@PathVariable int id) {
        return drugService.getDrugsByPrescriptionId(id);
    }

    @GetMapping("prescriptions/{id}/diseases")
    public List<Disease> getPrescriptionDiseases(@PathVariable int id) {
        return diseaseService.getDiseasesByPrescriptionId(id);
    }

    @PostMapping("prescriptions")
    public int savePrescription(@RequestBody Prescription prescription) {
        return prescriptionService.savePrescription(prescription);
    }

    @PutMapping("prescriptions")
    public void updatePrescription(@RequestBody Prescription prescription) {
        prescriptionService.updatePrescription(prescription);
    }

    @DeleteMapping("prescriptions/{id}")
    public void deletePrescription(@PathVariable int id) {
        prescriptionService.deletePrescription(id);
    }
}
