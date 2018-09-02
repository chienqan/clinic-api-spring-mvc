package repository;

import model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    List<Patient> findPatientsById(int id);
    List<Patient> findPatientsByName(String name);
    List<Patient> findPatientsByBirthday(String birthday);
}
