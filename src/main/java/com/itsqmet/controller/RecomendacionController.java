package com.itsqmet.controller;

import com.itsqmet.entity.Recomendacion;
import com.itsqmet.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    // VER TODAS LAS RECOMENDACIONES (USUARIO + ESPECIALISTA)
    @GetMapping
    public String verRecomendaciones(Model model) {
        List<Recomendacion> recomendaciones = recomendacionService.obtenerTodas();
        model.addAttribute("recomendaciones", recomendaciones);
        return "pages/recomendacion";
    }

    // FORMULARIO PARA CREAR/EDITAR (SOLO ESPECIALISTA)
    @GetMapping("/form")
    public String formularioRecomendacion(Model model) {
        model.addAttribute("recomendacion", new Recomendacion());
        return "pages/recomendacionForm";
    }

    // FORMULARIO PARA EDITAR POR NIVEL
    @GetMapping("/editar/{nivel}")
    public String editarPorNivel(@PathVariable String nivel, Model model) {
        Optional<Recomendacion> recomendacion = recomendacionService.obtenerPorNivel(nivel);
        model.addAttribute("recomendacion", recomendacion.orElse(new Recomendacion()));
        return "pages/recomendacionForm";
    }

    // GUARDAR RECOMENDACIÓN (SOLO ESPECIALISTA)
    @PostMapping("/guardar")
    public String guardarRecomendacion(@ModelAttribute Recomendacion recomendacion) {
        recomendacionService.guardar(recomendacion);
        return "redirect:/recomendaciones";
    }

    // ELIMINAR (SOLO ESPECIALISTA)
    @GetMapping("/eliminar/{id}")
    public String eliminarRecomendacion(@PathVariable Long id) {
        recomendacionService.eliminar(id);
        return "redirect:/recomendaciones";
    }
}