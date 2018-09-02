package repository;

import model.Medicine;
import org.springframework.data.repository.CrudRepository;

public interface MedicineRepository extends CrudRepository<Medicine, String> {
}
