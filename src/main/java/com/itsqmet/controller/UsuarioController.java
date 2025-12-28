package com.itsqmet.controller;

import com.itsqmet.entity.Usuario;
import com.itsqmet.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    // Inyeccion de dependencias
    @Autowired
    private UsuarioService usuarioService;

    // LEER
    @GetMapping
    public String listaUsuarios(@RequestParam(name = "buscar", required = false, defaultValue = "") String buscar, Model model) {
        List<Usuario> usuarios = usuarioService.buscarUsuarioPorNombreOCedula(buscar);
        model.addAttribute("buscar", buscar);
        model.addAttribute("usuarios", usuarios);
        return "pages/usuarioList";
    }

    // GUARDAR
    // 1. Llamar al formulario
    @GetMapping("/formUsuario")
    public String formularioUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "pages/usuarioForm";
    }

    // 2. Enviar datos a la vista (PARA AMBOS: crear y actualizar)
    @PostMapping("/registrarUsuario")
    public String guardarUsuario(@Valid @ModelAttribute Usuario usuario) {
        // Si tiene ID, llama a actualizar; si no, llama a guardar
        if (usuario.getId() != null) {
            usuarioService.actualizarUsuario(usuario.getId(), usuario);
        } else {
            usuarioService.guardarUsuario(usuario);
        }
        return "redirect:/test/formTest";
    }

    // Actualizar (SOLO carga el formulario con datos)
    @GetMapping("/editarUsuario/{id}")
    public String actualizarUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "pages/usuarioForm";
    }

    // Eliminar
    @DeleteMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}