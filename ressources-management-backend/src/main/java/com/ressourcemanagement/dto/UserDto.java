package com.ressourcemanagement.dto;

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
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String role;

}
