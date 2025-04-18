package fr.eseo.twic.petnkeu.apiserver.model;

import java.time.LocalDate;
import java.util.Optional;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Employees {

        private Integer empNo;

        private LocalDate birthDate; // Date de naissance
        private String firstName; // Prénom
        private String lastName; // Nom
        private LocalDate hireDate; // Date d'embauche

        // remplace toutes les valeurs de l'employé actuel par celles d'un autre employé
        @NotNull
        public Employees updateUsing(@NotNull Employees other) {
            this.firstName = other.getFirstName();
            this.lastName = other.getLastName();
            this.birthDate = other.getBirthDate();
            this.hireDate = other.getHireDate();
            return this;
        }

        // met à jour les valeurs de l'employé actuel uniquement si elles sont non nulles dans l'autre employé
        @NotNull
        public Employees patchUsing(@NotNull Employees other) {
            this.firstName = Optional.ofNullable(other.getFirstName()).orElse(this.firstName);
            this.lastName = Optional.ofNullable(other.getLastName()).orElse(this.lastName);
            this.birthDate = Optional.ofNullable(other.getBirthDate()).orElse(this.birthDate);
            this.hireDate = Optional.ofNullable(other.getHireDate()).orElse(this.hireDate);
            return this;
        }


}
