package controller;

import model.custom.DrugUsedPerDay;
import model.custom.PrescriptionOfVisitPerDay;
import model.custom.PatientOfVisitPerDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DrugService;
import service.VisitService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ReportController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private DrugService drugService;

    @GetMapping("reports/number-of-patient-visit-per-day")
    public List<PatientOfVisitPerDay> getNumberOfPatientVisitsPerDay() {
        return visitService.getNumberOfPatientVisitsPerDay();
    }

    @GetMapping("reports/number-of-drug-used-per-day")
    public List<DrugUsedPerDay> getNumberOfDrugsUsedPerDay() {
        return visitService.getNumberOfDrugUsedPerDay();
    }
}
