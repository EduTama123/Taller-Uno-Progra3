package com.itsqmet.service;

import com.itsqmet.entity.Recomendacion;
import com.itsqmet.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    // Obtener todas las recomendaciones
    public List<Recomendacion> obtenerTodas() {
        return recomendacionRepository.findAllByOrderByNivelAnsiedadAsc();
    }

    // Obtener por nivel de ansiedad
    public Optional<Recomendacion> obtenerPorNivel(String nivelAnsiedad) {
        return recomendacionRepository.findByNivelAnsiedad(nivelAnsiedad);
    }

    // Guardar o actualizar recomendación
    public void guardar(Recomendacion recomendacion) {
        // Si ya existe una recomendación para este nivel, actualizarla
        Optional<Recomendacion> existente = recomendacionRepository.findByNivelAnsiedad(recomendacion.getNivelAnsiedad());

        if (existente.isPresent()) {
            // Actualizar la existente
            Recomendacion rec = existente.get();
            rec.setRecomendacion1(recomendacion.getRecomendacion1());
            rec.setRecomendacion2(recomendacion.getRecomendacion2());
            rec.setRecomendacion3(recomendacion.getRecomendacion3());
            rec.setRecomendacion4(recomendacion.getRecomendacion4());
            rec.setRecomendacion5(recomendacion.getRecomendacion5());
            recomendacionRepository.save(rec);
        } else {
            // Crear nueva
            recomendacionRepository.save(recomendacion);
        }
    }

    // Obtener por ID
    public Optional<Recomendacion> obtenerPorId(Long id) {
        return recomendacionRepository.findById(id);
    }

    // Eliminar
    public void eliminar(Long id) {
        recomendacionRepository.deleteById(id);
    }
}