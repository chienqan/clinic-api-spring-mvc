package controller;

import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DrugService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping(path = "drugs", method = RequestMethod.GET)
    public List<Drug> getAllDiagnoses(){
        return drugService.getAllDrugs();
    }

    @RequestMapping(path = "drugs", method = RequestMethod.POST)
    public int addDrug(@RequestBody Drug drug){
        return drugService.addDrug(drug);
    }

    @RequestMapping(path = "drugs", method = RequestMethod.PUT)
    public void updateDrug(@RequestBody Drug drug){
        drugService.updateDrug(drug);
    }

    @RequestMapping(path = "drugs/{drugId}", method = RequestMethod.DELETE)
    public void deleteDrug(@PathVariable int drugId){
        drugService.deleteDrug(drugId);
    }

    @RequestMapping(path = "drugs/{drugId}", method = RequestMethod.GET)
    public Drug getDrug(@PathVariable int drugId){
        return drugService.getDrug(drugId);
    }

}
