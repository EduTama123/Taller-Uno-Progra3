package com.itsqmet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/especialista")
public class EspecialistaController {

    @GetMapping
    public String panelEspecialista(){
        return "pages/panelEspecialista";
    }
}