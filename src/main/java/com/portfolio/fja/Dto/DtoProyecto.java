package com.portfolio.fja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String periodo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String tecnologias;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String tecnologias, String periodo, String descripcion) {
        this.nombre = nombre;
        this.tecnologias = tecnologias;
        this.periodo = periodo;
        this.descripcion = descripcion;
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
        return "DtoProyecto{" + "Nombre: " + this.nombre + ", Tecnologías: " + this.tecnologias + ", Período: " + this.periodo + ", Descripción: " + this.descripcion + '}';
    }
}