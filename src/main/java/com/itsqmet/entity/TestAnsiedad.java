package com.itsqmet.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TestAnsiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer puntuacionTotal;
    private String nivelAnsiedad;

    // Campos para las 10 respuestas (0-3 puntos cada una)
    private Integer pregunta1;
    private Integer pregunta2;
    private Integer pregunta3;
    private Integer pregunta4;
    private Integer pregunta5;
    private Integer pregunta6;
    private Integer pregunta7;
    private Integer pregunta8;
    private Integer pregunta9;
    private Integer pregunta10;

    // Constructor vacío
    public TestAnsiedad() {
    }

    // Constructor con todos los parámetros
    public TestAnsiedad(Integer pregunta1, Integer pregunta2,
                        Integer pregunta3, Integer pregunta4, Integer pregunta5,
                        Integer pregunta6, Integer pregunta7, Integer pregunta8,
                        Integer pregunta9, Integer pregunta10) {
        this.pregunta1 = pregunta1;
        this.pregunta2 = pregunta2;
        this.pregunta3 = pregunta3;
        this.pregunta4 = pregunta4;
        this.pregunta5 = pregunta5;
        this.pregunta6 = pregunta6;
        this.pregunta7 = pregunta7;
        this.pregunta8 = pregunta8;
        this.pregunta9 = pregunta9;
        this.pregunta10 = pregunta10;
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(Integer puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public String getNivelAnsiedad() {
        return nivelAnsiedad;
    }

    public void setNivelAnsiedad(String nivelAnsiedad) {
        this.nivelAnsiedad = nivelAnsiedad;
    }

    public Integer getPregunta1() {
        return pregunta1;
    }

    public void setPregunta1(Integer pregunta1) {
        this.pregunta1 = pregunta1;
    }

    public Integer getPregunta2() {
        return pregunta2;
    }

    public void setPregunta2(Integer pregunta2) {
        this.pregunta2 = pregunta2;
    }

    public Integer getPregunta3() {
        return pregunta3;
    }

    public void setPregunta3(Integer pregunta3) {
        this.pregunta3 = pregunta3;
    }

    public Integer getPregunta4() {
        return pregunta4;
    }

    public void setPregunta4(Integer pregunta4) {
        this.pregunta4 = pregunta4;
    }

    public Integer getPregunta5() {
        return pregunta5;
    }

    public void setPregunta5(Integer pregunta5) {
        this.pregunta5 = pregunta5;
    }

    public Integer getPregunta6() {
        return pregunta6;
    }

    public void setPregunta6(Integer pregunta6) {
        this.pregunta6 = pregunta6;
    }

    public Integer getPregunta7() {
        return pregunta7;
    }

    public void setPregunta7(Integer pregunta7) {
        this.pregunta7 = pregunta7;
    }

    public Integer getPregunta8() {
        return pregunta8;
    }

    public void setPregunta8(Integer pregunta8) {
        this.pregunta8 = pregunta8;
    }

    public Integer getPregunta9() {
        return pregunta9;
    }

    public void setPregunta9(Integer pregunta9) {
        this.pregunta9 = pregunta9;
    }

    public Integer getPregunta10() {
        return pregunta10;
    }

    public void setPregunta10(Integer pregunta10) {
        this.pregunta10 = pregunta10;
    }
}