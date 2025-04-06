package fr.eseo.twic.petnkeu.apiserver.repository;

import fr.eseo.twic.petnkeu.apiserver.model.DepartmentEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcDepartmentRepository extends ListCrudRepository<DepartmentEntity, String> {
}
