package repository;

import model.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends CrudRepository<Disease, Integer> {
    List<Disease> findDiseasesByPrescriptionId(int id);
}
