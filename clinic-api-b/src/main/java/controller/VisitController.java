package controller;

import model.Visit;
import model.VisitReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.VisitService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @RequestMapping(path = "visits", method = RequestMethod.GET)
    public List<Visit> getAllVisits(){
        return visitService.getAllVisits();
    }

    @RequestMapping(path = "visits", method = RequestMethod.POST)
    public int addVisit(@RequestBody Visit visit){
        return visitService.addVisit(visit);
    }

    @RequestMapping(path = "visits", method = RequestMethod.PUT)
    public void updateVisit(@RequestBody Visit visit){
        visitService.updateVisit(visit);
    }

    @RequestMapping(path = "visits/{visitId}", method = RequestMethod.DELETE)
    public void deleteVisit(@PathVariable int visitId){
        visitService.deleteVisit(visitId);
    }

    @RequestMapping(path = "visits/{visitId}", method = RequestMethod.GET)
    public Visit getVisit(@PathVariable int visitId){
        return visitService.getVisit(visitId);
    }

    @RequestMapping(path = "visitsByDate", method = RequestMethod.GET)
    public List<Visit> getVisitByDate(@RequestParam String date) {
        return visitService.findVisitByDate(date);
    }

    @RequestMapping(path = "visits/patient/{patientId}", method = RequestMethod.GET)
    public List<Visit> getVisitByPatient(@PathVariable int patientId) {
        return visitService.findVisitByPatient(patientId);
    }
    @RequestMapping(path = "visitsPerDay", method = RequestMethod.GET)
    public List<VisitReport> getVisitsPerDay(){
        return visitService.countVisitPerDay();
    }
}
