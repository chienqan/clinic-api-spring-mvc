package repository;

import model.LabService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabServiceRepository extends CrudRepository<LabService, Integer> {
}
