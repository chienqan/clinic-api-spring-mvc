package controller;

import model.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DiagnosisService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @RequestMapping(path = "diagnosis", method = RequestMethod.GET)
    public List<Diagnosis> getAllDiagnoses(){
        return diagnosisService.getAllDiagnoses();
    }

    @RequestMapping(path = "diagnosis", method = RequestMethod.POST)
    public int addDiagnosis(@RequestBody Diagnosis diagnosis){
        return diagnosisService.addDiagnosis(diagnosis);
    }

    @RequestMapping(path = "diagnosis", method = RequestMethod.PUT)
    public void updateDiagnosis(@RequestBody Diagnosis diagnosis){
        diagnosisService.updateDiagnosis(diagnosis);
    }

    @RequestMapping(path = "diagnosis/{diagnosisId}", method = RequestMethod.DELETE)
    public void deleteDiagnosis(@PathVariable int diagnosisId){
        diagnosisService.deleteDiagnosis(diagnosisId);
    }

    @RequestMapping(path = "diagnosis/{diagnosisId}", method = RequestMethod.GET)
    public Diagnosis getDiagnosis(@PathVariable int diagnosisId){
        return diagnosisService.getDiagnosis(diagnosisId);
    }

    @RequestMapping(path = "diagnosis/visit/{visitId}", method = RequestMethod.GET)
    public List<Diagnosis> getDiagnosisByVisit(@PathVariable int visitId){
        return diagnosisService.getDiagnosisByVisit(visitId);
    }

}
