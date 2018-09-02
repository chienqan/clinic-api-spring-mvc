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

    @GetMapping("diseases")
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }

    @GetMapping("diseases/{id}")
    public Disease getDisease(@PathVariable int id) {
        return diseaseService.getDisease(id);
    }

    @PostMapping("diseases")
    public int saveDisease(@RequestBody Disease disease) {
        return diseaseService.saveDisease(disease);
    }

    @PutMapping("diseases")
    public void updateDisease(@RequestBody Disease disease) {
        diseaseService.updateDisease(disease);
    }

    @DeleteMapping("diseases/{id}")
    public void deleteDisease(@PathVariable int id) {
        diseaseService.deleteDisease(id);
    }
}
