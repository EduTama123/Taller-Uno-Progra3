package com.itsqmet.controller;

import com.itsqmet.entity.TestAnsiedad;
import com.itsqmet.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    //LEER - Listar todos los tests
    @GetMapping
    public String listaTests(Model model) {
        List<TestAnsiedad> tests = testService.mostrarTests();
        model.addAttribute("tests", tests);
        return "pages/testList";
    }

    //GUARDAR
    //1. Llamar al formulario
    @GetMapping("/formTest")
    public String formularioTest(Model model) {
        model.addAttribute("testAnsiedad", new TestAnsiedad());
        return "pages/testForm";
    }

    //2. Enviar datos del formulario
    @PostMapping("/registrarTest")
    public String guardarTest(@ModelAttribute TestAnsiedad testAnsiedad, Model model) {
        System.out.println("Guardando test...");
        TestAnsiedad guardado = testService.guardarTest(testAnsiedad);
        model.addAttribute("test", guardado);
        return "pages/resultadoTest";
    }

    //VER RESULTADO
    @GetMapping("/resultado/{id}")
    public String verResultado(@PathVariable Long id, Model model) {
        Optional<TestAnsiedad> test = testService.buscarTest(id);
        if (test.isPresent()) {
            model.addAttribute("test", test.get());
            return "pages/resultadoTest";
        }
        return "redirect:/test";
    }

    //ELIMINAR
    @GetMapping("/eliminarTest/{id}")
    public String eliminarTest(@PathVariable Long id) {
        testService.eliminarTest(id);
        return "redirect:/test";
    }
}