package com.itsqmet.repository;

import com.itsqmet.entity.Recomendacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RecomendacionRepository extends JpaRepository<Recomendacion, Long> {

    // Buscar por nivel de ansiedad
    Optional<Recomendacion> findByNivelAnsiedad(String nivelAnsiedad);

    // Buscar todos ordenados por nivel
    List<Recomendacion> findAllByOrderByNivelAnsiedadAsc();
}