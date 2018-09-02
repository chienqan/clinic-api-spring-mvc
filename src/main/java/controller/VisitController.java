package controller;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.VisitService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping("visits")
    public List<Visit> getVisits(@RequestParam(required = false) String date, @RequestParam(required = false) Integer patientId) {

        List<Visit> visits;

        if(date != null) {
            visits = visitService.getVisitsByDate(date);
        } else if(patientId != null) {
            visits = visitService.getVisitsByPatientId(patientId);
        } else {
            visits = visitService.getAllVisits();
        }

        return visits;
    }

    @GetMapping("visits/{id}")
    public Visit getVisit(@PathVariable int id){
        return visitService.getVisit(id);
    }

    @PostMapping("visits")
    public int saveVisit(@RequestBody Visit visit) {
        return visitService.saveVisit(visit);
    }

    @PutMapping("visits")
    public void updateVisit(@RequestBody  Visit visit) {
        visitService.updateVisit(visit);
    }

    @DeleteMapping("visits/{id}")
    public void deleteVisit(@PathVariable int id){
        visitService.deleteVisit(id);
    }
}
