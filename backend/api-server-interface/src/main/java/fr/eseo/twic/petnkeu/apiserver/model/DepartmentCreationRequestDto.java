package fr.eseo.twic.petnkeu.apiserver.model;

import jakarta.validation.constraints.NotNull;

public record DepartmentCreationRequestDto(@NotNull String deptNo, String deptName) {
}
