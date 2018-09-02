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

    @GetMapping("drugs")
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("drugs/{id}")
    public Drug getDrug(@PathVariable int id) {
        return drugService.getDrug(id);
    }

    @PostMapping("drugs")
    public int saveDrug(@RequestBody Drug drug) {
        return drugService.saveDrug(drug);
    }

    @PutMapping("drugs")
    public void updateDrug(@RequestBody Drug drug) {
        drugService.updateDrug(drug);
    }

    @DeleteMapping("drugs/{id}")
    public void deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
    }
}
