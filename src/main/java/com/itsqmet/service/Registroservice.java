package com.itsqmet.service;

import com.itsqmet.entity.RegistroEmocional;
import com.itsqmet.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class Registroservice {
    //IoC - inyeccion de dependencias
    @Autowired
    private RegistroRepository registroRepository;

    //Listar registros
    public List<RegistroEmocional> mostrarRegistroEmocional(){
        return registroRepository.findAll();
    }

    //Buscar por id
    public Optional<RegistroEmocional> buscarRegistroEmocional(Long id){
        return registroRepository.findById(id);
    }

    //Guardar registro
    public RegistroEmocional guardarRegistroEmocional(RegistroEmocional registroEmocional){
        registroRepository.save(registroEmocional);
        return registroEmocional;
    }

    //Actualizar registro por id
    public RegistroEmocional actualizarRegistroEmocional (Long id, RegistroEmocional registroEmocional){
        RegistroEmocional registroEmocionalExistente = buscarRegistroEmocional(id)
                .orElseThrow(()-> new RuntimeException("El Registro Emocional no existe"));
        registroEmocionalExistente.setEmocion(registroEmocional.getEmocion());
        registroEmocionalExistente.setDescripcion(registroEmocional.getDescripcion());
        registroEmocionalExistente.setIntensidad(registroEmocional.getIntensidad());
        registroEmocionalExistente.setCategoria(registroEmocional.getCategoria());
        return registroRepository.save(registroEmocionalExistente);
    }

    //Eliminar Registro Emocional por el id
    public void eliminarRegistroEmocional(Long id){
        RegistroEmocional registroEmocional = buscarRegistroEmocional(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "El Registro Emocional no existe"));
        registroRepository.delete(registroEmocional);
    }
}
