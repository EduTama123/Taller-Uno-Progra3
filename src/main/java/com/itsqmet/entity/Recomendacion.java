package com.itsqmet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nivelAnsiedad; // "Leve", "Moderado", "Severo"
    private String recomendacion1;
    private String recomendacion2;
    private String recomendacion3;
    private String recomendacion4;
    private String recomendacion5;

    // Constructor vacío
    public Recomendacion() {
    }

    // Constructor con parámetros
    public Recomendacion(String nivelAnsiedad, String recomendacion1, String recomendacion2,
                         String recomendacion3, String recomendacion4, String recomendacion5) {
        this.nivelAnsiedad = nivelAnsiedad;
        this.recomendacion1 = recomendacion1;
        this.recomendacion2 = recomendacion2;
        this.recomendacion3 = recomendacion3;
        this.recomendacion4 = recomendacion4;
        this.recomendacion5 = recomendacion5;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivelAnsiedad() {
        return nivelAnsiedad;
    }

    public void setNivelAnsiedad(String nivelAnsiedad) {
        this.nivelAnsiedad = nivelAnsiedad;
    }

    public String getRecomendacion1() {
        return recomendacion1;
    }

    public void setRecomendacion1(String recomendacion1) {
        this.recomendacion1 = recomendacion1;
    }

    public String getRecomendacion2() {
        return recomendacion2;
    }

    public void setRecomendacion2(String recomendacion2) {
        this.recomendacion2 = recomendacion2;
    }

    public String getRecomendacion3() {
        return recomendacion3;
    }

    public void setRecomendacion3(String recomendacion3) {
        this.recomendacion3 = recomendacion3;
    }

    public String getRecomendacion4() {
        return recomendacion4;
    }

    public void setRecomendacion4(String recomendacion4) {
        this.recomendacion4 = recomendacion4;
    }

    public String getRecomendacion5() {
        return recomendacion5;
    }

    public void setRecomendacion5(String recomendacion5) {
        this.recomendacion5 = recomendacion5;
    }
}