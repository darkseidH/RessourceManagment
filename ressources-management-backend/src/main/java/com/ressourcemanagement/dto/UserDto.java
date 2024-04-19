package com.ressourcemanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String nom;

    @NotNull
    @Size(min = 2, max = 30)
    private String prenom;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String role;
    private long departement_id;

}
