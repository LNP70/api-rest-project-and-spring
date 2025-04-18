package fr.eseo.twic.petnkeu.apiserver.model;
import java.time.LocalDate;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Title {
    private Integer empNo;
    private LocalDate fromDate;
    private String title;
    private LocalDate toDate;

    @NotNull
    public Title updateUsing(@NotNull Title other) {
        this.title = other.getTitle();
        this.toDate = other.getToDate();
        return this;
    }

    @NotNull
    public Title patchUsing(@NotNull Title other) {
        this.title = Optional.ofNullable(other.getTitle()).orElse(this.title);
        this.toDate = Optional.ofNullable(other.getToDate()).orElse(this.toDate);
        return this;
    }
}
