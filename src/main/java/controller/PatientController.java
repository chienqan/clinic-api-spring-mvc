package controller;

import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("patients")
    public List<Patient> getAllPatients(@RequestParam(required = false) Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String birthday) {

        List<Patient> patients;

        if(id != null) {
            patients = patientService.getPatientsById(id);
        } else if(name != null) {
            patients = patientService.getPatientsByName(name);
        } else if(birthday != null) {
            patients = patientService.getPatientsByBirthDay(birthday);
        } else {
            patients = patientService.getAllPatients();
        }

        return patients;
    }

    @GetMapping("patients/{id}")
    public Patient getPatient(@PathVariable int id) {
        return patientService.getPatient(id);
    }

    @PostMapping("patients")
    public int savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("patients")
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }

    @DeleteMapping("patients/{id}")
    public void deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
    }
}
