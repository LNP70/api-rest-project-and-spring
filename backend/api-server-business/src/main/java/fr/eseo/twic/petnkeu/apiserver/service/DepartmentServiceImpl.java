package fr.eseo.twic.petnkeu.apiserver.service;

import fr.eseo.twic.petnkeu.apiserver.model.Department;
import fr.eseo.twic.petnkeu.apiserver.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    @Override
    public Optional<Department> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> create(Department department) {
        return repository.findById(department.getDeptNo())
                .map(dep -> Optional.<Department>empty())
                .orElseGet(() -> Optional.of(repository.save(department)));
    }

    @Override
    public Optional<Department> update(Department department) {
        return repository.findById(department.getDeptNo())
                .map(dep -> dep.updateUsing(department))
                .map(repository::save);
    }

    @Override
    public Optional<Department> updatePartially(Department department) {
        return repository.findById(department.getDeptNo())
                .map(dep -> dep.patchUsing(department))
                .map(repository::save);
    }

    @Override
    public Optional<Department> deleteById(String id) {
        return repository.findById(id)
                .map(department -> {
                    repository.deleteById(id);
                    return department;
                });
    }
}
