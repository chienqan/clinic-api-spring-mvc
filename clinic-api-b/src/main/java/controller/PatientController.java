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

    @RequestMapping(path = "patients", method = RequestMethod.GET)
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @RequestMapping(path = "patients", method = RequestMethod.POST)
    public int addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @RequestMapping(path = "patients", method = RequestMethod.PUT)
    public void updatePatient(@RequestBody Patient patient){
        patientService.updatePatient(patient);
    }

    @RequestMapping(path = "patients/{patientId}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable int patientId){
        patientService.deletePatient(patientId);
    }

    @RequestMapping(path = "patients/{patientId}", method = RequestMethod.GET)
    public Patient getPatient(@PathVariable int patientId){
        return patientService.getPatient(patientId);
    }

    @RequestMapping(path = "patientsByName", method = RequestMethod.GET)
    public List<Patient> getPatientByName(@RequestParam String name){
        return patientService.findPatientByName(name);
    }

    @RequestMapping(path = "patientsByBirthdate", method = RequestMethod.GET)
    public List<Patient> getPatientByBirthdate(@RequestParam String birthdate){
        return patientService.findPatientByBirthdate(birthdate);
    }

}
