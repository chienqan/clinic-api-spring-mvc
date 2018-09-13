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
    private LabServiceService addressService;
    @GetMapping("labservice")
    public List<LabService> getAllLabServicees() {
        return addressService.getAllLabServicees();
    }

    @GetMapping("labservice/{id}")
    public LabService getLabService(@PathVariable int id) {
        return addressService.getLabService(id);
    }

    @PostMapping("labservice")
    public int saveLabService(@RequestBody LabService labService) {
        return addressService.saveLabService(labService);
    }

    @PutMapping("labservice")
    public void updateLabService(@RequestBody LabService labService) {
        addressService.updateLabService(labService);
    }

    @DeleteMapping("labservice/{id}")
    public void deleteLabService(@PathVariable int id) {
        addressService.deleteLabService(id);
    }
}
