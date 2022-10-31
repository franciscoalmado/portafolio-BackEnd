package com.portfolio.fja.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 2, max = 10, message = "No cumple con la longitud")
    private String nivelDeIdioma;
    
    public Idioma() {
    }

    public Idioma(String nombre, String nivelDeIdioma) {
        this.nombre = nombre;
        this.nivelDeIdioma = nivelDeIdioma;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
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
        return "Idioma{" + "iD: " + this.id + ", Nombre: " + this.nombre + ", Nivel de Idioma: " + this.nivelDeIdioma + '}';
    }
}