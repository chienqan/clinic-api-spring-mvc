package controller;

import model.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LabServiceService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class LabServiceController {

    @Autowired
    private LabServiceService labServiceService;

    @RequestMapping(path = "labService", method = RequestMethod.GET)
    public List<LabService> getAllDiagnoses(){
        return labServiceService.getAllDiagnoses();
    }

    @RequestMapping(path = "labService", method = RequestMethod.POST)
    public int addLabService(@RequestBody LabService labService){
        return labServiceService.addLabService(labService);
    }

    @RequestMapping(path = "labService", method = RequestMethod.PUT)
    public void updateLabService(@RequestBody LabService labService){
        labServiceService.updateLabService(labService);
    }

    @RequestMapping(path = "labService/{labServiceId}", method = RequestMethod.DELETE)
    public void deleteLabService(@PathVariable int labServiceId){
        labServiceService.deleteLabService(labServiceId);
    }

    @RequestMapping(path = "labService/{labServiceId}", method = RequestMethod.GET)
    public LabService getLabService(@PathVariable int labServiceId){
        return labServiceService.getLabService(labServiceId);
    }

}
