package controller;

import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PrescriptionService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping(path = "prescriptions", method = RequestMethod.GET)
    public List<Prescription> getAllPrescriptions(){
        return prescriptionService.getAllPrescriptions();
    }

    @RequestMapping(path = "prescriptions", method = RequestMethod.POST)
    public int addPrescription(@RequestBody Prescription prescription){
        return prescriptionService.addPrescription(prescription);
    }

    @RequestMapping(path = "prescriptions", method = RequestMethod.PUT)
    public void updatePrescription(@RequestBody Prescription prescription){
        prescriptionService.updatePrescription(prescription);
    }

    @RequestMapping(path = "prescriptions/{prescriptionId}", method = RequestMethod.DELETE)
    public void deletePrescription(@PathVariable int prescriptionId){
        prescriptionService.deletePrescription(prescriptionId);
    }

    @RequestMapping(path = "prescriptions/{prescriptionId}", method = RequestMethod.GET)
    public Prescription getPrescription(@PathVariable int prescriptionId){
        return prescriptionService.getPrescription(prescriptionId);
    }
}
