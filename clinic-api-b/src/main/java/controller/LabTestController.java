package controller;

import model.LabTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LabTestService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    @RequestMapping(path = "labTests", method = RequestMethod.GET)
    public List<LabTest> getAllDiagnoses(){
        return labTestService.getAllDiagnoses();
    }

    @RequestMapping(path = "labTests", method = RequestMethod.POST)
    public int addLabTest(@RequestBody LabTest labTest){
        return labTestService.addLabTest(labTest);
    }

    @RequestMapping(path = "labTests", method = RequestMethod.PUT)
    public void updateLabTest(@RequestBody LabTest labTest){
        labTestService.updateLabTest(labTest);
    }

    @RequestMapping(path = "labTests/{labTestId}", method = RequestMethod.DELETE)
    public void deleteLabTest(@PathVariable int labTestId){
        labTestService.deleteLabTest(labTestId);
    }

    @RequestMapping(path = "labTests/{labTestId}", method = RequestMethod.GET)
    public LabTest getLabTest(@PathVariable int labTestId){
        return labTestService.getLabTest(labTestId);
    }

}
