package com.portfolio.fja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    
    @NotBlank
    private String institucion;
    
    @NotBlank
    private String carrera;
    
    @NotBlank
    private String periodo;
    
    @NotBlank
    private String comentarios;

    public DtoEducacion() {
    }

    public DtoEducacion(String institucion, String carrera, String periodo, String comentarios) {
        this.institucion = institucion;
        this.carrera = carrera;
        this.periodo = periodo;
        this.comentarios = comentarios;
    }

    public String getInstitucion() {
        return this.institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getCarrera() {
        return this.carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getComentarios() {
        return this.comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }   
}