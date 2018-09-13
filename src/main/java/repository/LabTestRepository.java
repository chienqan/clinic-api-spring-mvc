package repository;

import model.LabTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestRepository extends CrudRepository<LabTest, Integer> {
}
