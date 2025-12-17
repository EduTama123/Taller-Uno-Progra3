package com.itsqmet.controlador;

import com.itsqmet.entity.RegistroEmocional;
import com.itsqmet.service.Registroservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiRegistroEmocional")
public class RegistroController {

    @Autowired
    private Registroservice registroservice;
    private List<RegistroEmocional> registroEmocional;

    //Leer
    @GetMapping
    public List<RegistroEmocional> listaRegistroEmocional(){
        registroEmocional = registroservice.mostrarRegistroEmocional();
        return registroEmocional;
    }

    //Buscar registro por id
    @GetMapping("/{id}")
    public Optional<RegistroEmocional> buscarRegistroEmocionalById(@PathVariable Long id){
        return registroservice.buscarRegistroEmocional(id);
    }

    //Guardar Registro Emocional
    @PostMapping("/guardarRegistroEmocional/{id}")
    public RegistroEmocional guardarRegistroEmocional(@RequestBody RegistroEmocional registroEmocional){
        return registroservice.guardarRegistroEmocional(registroEmocional);
    }

    //Actualizar registro emocional
    @PutMapping("/actualizarRegistroEmocional")
        public RegistroEmocional actualizarRegistroEmocional(@PathVariable Long id,
                                                             @RequestBody RegistroEmocional registroEmocional){
        return registroservice.actualizarRegistroEmocional(id, registroEmocional);
    }

    //Eliminar registro emocional
    @DeleteMapping("/eliminarRegistroEmocional")
    public void eliminarRegistroEmocional(@PathVariable Long id){
        registroservice.eliminarRegistroEmocional(id);
    }

}
