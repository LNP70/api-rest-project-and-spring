package fr.eseo.twic.petnkeu.apiserver.service;

import fr.eseo.twic.petnkeu.apiserver.model.Department;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    @NotNull
    Optional<Department> findById(@NotNull String id);

    @NotNull
    List<Department> findAll();

    @NotNull
    Optional<Department> create(@NotNull Department department);

    @NotNull
    Optional<Department> update(@NotNull Department department);

    @NotNull
    Optional<Department> updatePartially(@NotNull Department department);

    @NotNull
    Optional<Department> deleteById(@NotNull String id);
}
