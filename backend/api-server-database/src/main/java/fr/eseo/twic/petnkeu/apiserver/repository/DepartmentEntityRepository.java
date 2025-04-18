package fr.eseo.twic.petnkeu.apiserver.repository;

import fr.eseo.twic.petnkeu.apiserver.mapper.DepartmentEntityMapper;
import fr.eseo.twic.petnkeu.apiserver.model.Department;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DepartmentEntityRepository implements DepartmentRepository {

    private final JdbcDepartmentRepository repository;
    private final DepartmentEntityMapper mapper;

    @NotNull
    @Override
    public Optional<Department> findById(@NotNull String id) {
        return repository.findById(id).map(mapper::toBo);
    }

    @NotNull
    @Override
    public List<Department> findAll() {
        return repository.findAll().stream().map(mapper::toBo).toList();
    }

    @Override
    public Department save(Department department) {
        return mapper.toBo(repository.save(mapper.toEntity(department)));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
