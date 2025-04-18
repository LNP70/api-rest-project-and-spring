package fr.eseo.twic.petnkeu.apiserver.repository;
import fr.eseo.twic.petnkeu.apiserver.model.Employees;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface EmployeesRepository {
    @NotNull
    Optional<Employees> findById(@NotNull String id);

    @NotNull
    List<Employees> findAll();

    @NotNull
    Employees save(@NotNull Employees employees);

    void deleteById(@NotNull String id);
}
