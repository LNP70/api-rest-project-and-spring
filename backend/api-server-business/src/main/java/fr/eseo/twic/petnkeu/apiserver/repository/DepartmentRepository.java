package fr.eseo.twic.petnkeu.apiserver.repository;

import fr.eseo.twic.petnkeu.apiserver.model.Department;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository {

    @NotNull
    Optional<Department> findById(@NotNull String id);

    @NotNull
    List<Department> findAll();

    @NotNull
    Department save(@NotNull Department department);

    void deleteById(@NotNull String id);
}
