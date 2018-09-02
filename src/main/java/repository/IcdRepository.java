package repository;

import model.Icd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcdRepository extends CrudRepository<Icd, String> {

}
