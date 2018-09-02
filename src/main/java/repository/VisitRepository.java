package repository;

import model.custom.PrescriptionOfVisitPerDay;
import model.custom.PatientOfVisitPerDay;
import model.Visit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer> {
    @Query("SELECT new model.custom.PatientOfVisitPerDay(count(v.patient), v.date) FROM Visit v GROUP BY v.date")
    List<PatientOfVisitPerDay> findNumberOfPatientVisitsPerDay();

    @Query("SELECT new model.custom.PrescriptionOfVisitPerDay(v.prescription.id, v.date) FROM Visit v GROUP BY v.date, v.prescription.id")
    List<PrescriptionOfVisitPerDay> findNumberOfDrugUsedPerDay();
    List<Visit> findVisitsByDate(String date);
    List<Visit> findVisitsByPatientId(int id);
}