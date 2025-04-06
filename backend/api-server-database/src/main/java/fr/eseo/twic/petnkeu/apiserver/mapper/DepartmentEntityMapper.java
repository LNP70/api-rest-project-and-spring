package fr.eseo.twic.petnkeu.apiserver.mapper;

import fr.eseo.twic.rosenzveig.apiserver.model.Department;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentEntity;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentEntityMapper {

    @Mapping(target = "updateUsing", ignore = true)
    @Mapping(target = "patchUsing", ignore = true)
    @NotNull
    Department toBo(@NotNull DepartmentEntity entity);

    @NotNull
    DepartmentEntity toEntity(@NotNull Department bo);
}
