package com.itsqmet.repository;

import com.itsqmet.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Metodo para buscar usuarios por nombre (ignorando mayusculas/minusculas)
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    // Metodo para buscar usuarios por cedula (busqueda exacta parcial)
    List<Usuario> findByCedulaContaining(String cedula);
}