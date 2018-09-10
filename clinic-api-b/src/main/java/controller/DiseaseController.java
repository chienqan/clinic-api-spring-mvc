package controller;

import model.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DiseaseService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @RequestMapping(path = "diseases", method = RequestMethod.GET)
    public List<Disease> getAllDiagnoses(){
        return diseaseService.getAllDiagnoses();
    }

    @RequestMapping(path = "diseases", method = RequestMethod.POST)
    public String addDisease(@RequestBody Disease disease){
        return diseaseService.addDisease(disease);
    }

    @RequestMapping(path = "diseases", method = RequestMethod.PUT)
    public void updateDisease(@RequestBody Disease disease){
        diseaseService.updateDisease(disease);
    }

    @RequestMapping(path = "diseases/{diseaseIcd}", method = RequestMethod.DELETE)
    public void deleteDisease(@PathVariable int diseaseId){
        diseaseService.deleteDisease(diseaseId);
    }

    @RequestMapping(path = "diseases/{diseaseIcd}", method = RequestMethod.GET)
    public Disease getDisease(@PathVariable int diseaseId){
        return diseaseService.getDisease(diseaseId);
    }

}
