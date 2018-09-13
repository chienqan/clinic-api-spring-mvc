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
    private LabTestService addressService;
    @GetMapping("labtests")
    public List<LabTest> getAllLabTestes() {
        return addressService.getAllLabTestes();
    }

    @GetMapping("labtests/{id}")
    public LabTest getLabTest(@PathVariable int id) {
        return addressService.getLabTest(id);
    }

    @PostMapping("labtests")
    public int saveLabTest(@RequestBody LabTest labTest) {
        return addressService.saveLabTest(labTest);
    }

    @PutMapping("labtests")
    public void updateLabTest(@RequestBody LabTest labTest) {
        addressService.updateLabTest(labTest);
    }

    @DeleteMapping("labtests/{id}")
    public void deleteLabTest(@PathVariable int id) {
        addressService.deleteLabTest(id);
    }
}
