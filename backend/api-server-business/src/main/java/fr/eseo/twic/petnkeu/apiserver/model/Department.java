package fr.eseo.twic.petnkeu.apiserver.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Department {

    private final String deptNo;
    private String deptName;

    @NotNull
    public Department updateUsing(@NotNull Department other) {
        deptName = other.getDeptName();
        return this;
    }

    @NotNull
    public Department patchUsing(@NotNull Department other) {
        deptName = Optional.of(other).map(Department::getDeptName).orElse(deptName);
        return this;
    }
}
