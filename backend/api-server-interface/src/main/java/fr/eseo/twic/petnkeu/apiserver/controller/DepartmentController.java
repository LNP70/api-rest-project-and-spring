package fr.eseo.twic.petnkeu.apiserver.controller;

import fr.eseo.twic.petnkeu.apiserver.mapper.DepartmentDtoMapper;
import fr.eseo.twic.petnkeu.apiserver.model.Department;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentCreationRequestDto;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentPatchRequestDto;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentResponseDto;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentUpdateRequestDto;
import fr.eseo.twic.petnkeu.apiserver.service.DepartmentService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v${api.version}/departments")
public class DepartmentController {

    private final DepartmentService service;
    private final DepartmentDtoMapper mapper;

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> findAll() {
        List<DepartmentResponseDto> departments = service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{deptNo}")
    public ResponseEntity<DepartmentResponseDto> findById(@PathVariable @NotNull String deptNo) {
        Optional<DepartmentResponseDto> department = service.findById(deptNo).map(mapper::toDto);
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.ok().build());
    }

    @PostMapping()
    public ResponseEntity<Void> create(@RequestBody @NotNull DepartmentCreationRequestDto body) {
        Optional<Department> department = service.create(mapper.toBo(body));
        if (department.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{deptNo}")
    public ResponseEntity<Void> update(@PathVariable @NotNull String deptNo, @RequestBody @NotNull DepartmentUpdateRequestDto body) {
        Optional<Department> department = service.update(mapper.toBo(deptNo, body));
        if (department.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping("/{deptNo}")
    public ResponseEntity<Void> update(@PathVariable @NotNull String deptNo, @RequestBody @NotNull DepartmentPatchRequestDto body) {
        Optional<Department> department = service.updatePartially(mapper.toBo(deptNo, body));
        if (department.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{deptNo}")
    public ResponseEntity<Void> update(@PathVariable @NotNull String deptNo) {
        Optional<Department> department = service.deleteById(deptNo);
        if (department.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
