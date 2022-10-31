package com.portfolio.fja.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String nombre;

    @NotNull
    @Size(min = 3, max = 300, message = "No cumple con la longitud")
    private String tecnologias;
        
    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String periodo;

    @NotNull
    @Size(min = 3, max = 600, message = "No cumple con la longitud")
    private String descripcion;
   
    public Proyecto() {
    }

    public Proyecto(String nombre, String tecnologias, String periodo, String descripcion) {
        this.nombre = nombre;
        this.tecnologias = tecnologias;
        this.periodo = periodo;
        this.descripcion = descripcion;
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

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(String tecnologias) {
        this.tecnologias = tecnologias;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "ID: " + this.id + ", Nombre: " + this.nombre + ", Tecnologías: " + this.tecnologias + ", Período: " + this.periodo + ", Descripción: " + this.descripcion + '}';
    }
}