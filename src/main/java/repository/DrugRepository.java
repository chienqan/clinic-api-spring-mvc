package repository;

import model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Integer> {
    List<Drug> findDrugsByPrescriptionId(int id);

}
