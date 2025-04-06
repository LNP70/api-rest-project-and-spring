package fr.eseo.twic.petnkeu.apiserver.mapper;

import fr.eseo.twic.petnkeu.apiserver.model.Department;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentCreationRequestDto;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentPatchRequestDto;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentResponseDto;
import fr.eseo.twic.petnkeu.apiserver.model.DepartmentUpdateRequestDto;
import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentDtoMapper {

    @Mapping(target = "updateUsing", ignore = true)
    @Mapping(target = "patchUsing", ignore = true)
    @NotNull
    Department toBo(@NotNull DepartmentCreationRequestDto dto);

    @Mapping(target = "updateUsing", ignore = true)
    @Mapping(target = "patchUsing", ignore = true)
    @Mapping(target = "deptNo", source = "id")
    @NotNull
    Department toBo(@NotNull String id, @NotNull DepartmentUpdateRequestDto dto);

    @Mapping(target = "updateUsing", ignore = true)
    @Mapping(target = "patchUsing", ignore = true)
    @Mapping(target = "deptNo", source = "id")
    @NotNull
    Department toBo(@NotNull String id, @NotNull DepartmentPatchRequestDto dto);

    @NotNull
    DepartmentResponseDto toDto(@NotNull Department bo);
}
