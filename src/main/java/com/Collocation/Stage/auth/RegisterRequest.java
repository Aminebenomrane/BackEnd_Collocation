package com.Collocation.Stage.auth;

import com.Collocation.Stage.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements Serializable {

        @NotBlank(message = "Le nom ne peut pas être vide")
        private String nom;

        @NotBlank(message = "Le prénom ne peut pas être vide")
        private String prenom;

        @NotBlank(message = "L'email ne peut pas être vide")
        @Email(message = "L'email doit être valide")
        private String email;

        @NotBlank(message = "Le mot de passe ne peut pas être vide")
        @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
        private String password;

        private Role role;
}
