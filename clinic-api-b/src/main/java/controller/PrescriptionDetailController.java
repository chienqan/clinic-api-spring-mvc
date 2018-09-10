package controller;

import model.DrugReport;
import model.PrescriptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PrescriptionDetailService;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PrescriptionDetailController {

    @Autowired
    private PrescriptionDetailService prescriptionDetailService;

    @RequestMapping(path = "prescriptionDetails", method = RequestMethod.GET)
    public List<PrescriptionDetail> getAllPrescriptionDetails(){
        return prescriptionDetailService.getAllPrescriptionDetails();
    }

    @RequestMapping(path = "prescriptionDetails", method = RequestMethod.POST)
    public int addPrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail){
        return prescriptionDetailService.addPrescriptionDetail(prescriptionDetail);
    }

    @RequestMapping(path = "prescriptionDetails", method = RequestMethod.PUT)
    public void updatePrescriptionDetail(@RequestBody PrescriptionDetail prescriptionDetail){
        prescriptionDetailService.updatePrescriptionDetail(prescriptionDetail);
    }

    @RequestMapping(path = "prescriptionDetails/{prescriptionDetailId}", method = RequestMethod.DELETE)
    public void deletePrescriptionDetail(@PathVariable int prescriptionDetailId){
        prescriptionDetailService.deletePrescriptionDetail(prescriptionDetailId);
    }

    @RequestMapping(path = "prescriptionDetails/{prescriptionDetailId}", method = RequestMethod.GET)
    public PrescriptionDetail getPrescriptionDetail(@PathVariable int prescriptionDetailId){
        return prescriptionDetailService.getPrescriptionDetail(prescriptionDetailId);
    }

    @RequestMapping(path = "details/prescription/{prescriptionId}", method = RequestMethod.GET)
    public List<PrescriptionDetail> getFullPrescription(@PathVariable int prescriptionId){
        return prescriptionDetailService.getDetailsByPrescription(prescriptionId);
    }

    @RequestMapping(path = "drugPrescribed", method = RequestMethod.GET)
    public DrugReport countDrugPrescribed(){
        return prescriptionDetailService.countDrugPrescribed();
    }
}
