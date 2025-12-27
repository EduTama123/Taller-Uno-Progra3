package com.itsqmet.entity;

import com.itsqmet.roles.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20)
    private String nombre;

    @NotNull
    @Size(min = 5, max = 10)
    private String username;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}
