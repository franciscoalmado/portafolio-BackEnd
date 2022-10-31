package com.portfolio.fja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoIdioma {

    @NotBlank
    private String nombre;
    
    @NotBlank
    private String nivelDeIdioma;
    
    public DtoIdioma() {
    }

    public DtoIdioma(String nombre, String nivelDeIdioma) {
        this.nombre = nombre;
        this.nivelDeIdioma = nivelDeIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeIdioma() {
        return nivelDeIdioma;
    }

    public void setNivelDeIdioma(String nivelDeIdioma) {
        this.nivelDeIdioma = nivelDeIdioma;
    }

    @Override
    public String toString() {
        return "DtoIdioma{" + "Nombre: " + this.nombre + ", Nivel de Idioma: " + this.nivelDeIdioma + '}';
    }
}