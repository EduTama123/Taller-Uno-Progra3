package com.itsqmet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre: solo letras y espacios, 2-30 caracteres
    @NotBlank(message = "El nombre es obligatorio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,30}$",
            message = "El nombre debe contener solo letras y tener entre 2-30 caracteres")
    private String nombre;

    // Apellido: solo letras y espacios, 2-30 caracteres
    @NotBlank(message = "El apellido es obligatorio")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,30}$",
            message = "El apellido debe contener solo letras y tener entre 2-30 caracteres")
    private String apellido;

    // Cédula: 10 dígitos numéricos (formato Ecuador)
    @NotBlank(message = "La cédula es obligatoria")
    @Pattern(regexp = "^[0-9]{10}$",
            message = "La cédula debe tener exactamente 10 dígitos")
    private String cedula;

    // Dirección: formato común de dirección, 5-100 caracteres
    @NotBlank(message = "La dirección es obligatoria")
    @Pattern(regexp = "^[A-Za-z0-9ÁÉÍÓÚáéíóúñÑ .,#-]{5,100}$",
            message = "La dirección debe tener entre 5-100 caracteres (letras, números, espacios, .,-,#)")
    private String direccion;

    // Teléfono: 10 dígitos, puede empezar con 09
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^09[0-9]{8}$",
            message = "El teléfono debe tener 10 dígitos y empezar con 09")
    private String telefono;

    // Edad: entre 18 y 100 años
    @Min(value = 18, message = "La edad mínima es 18 años")
    @Max(value = 100, message = "La edad máxima es 100 años")
    private int edad;

    // Constructor vacío (OBLIGATORIO para JPA)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombre, String apellido, String cedula,
                   String direccion, String telefono, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
