package com.portfolio.fja.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String institucion;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String carrera;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String periodo;
    
    @NotNull
    @Size(min = 3, max = 150, message = "No cumple con la longitud")
    private String comentarios;    

    public Educacion() {
    }

    public Educacion(String institucion, String carrera, String periodo, String comentarios) {
        this.institucion = institucion;
        this.carrera = carrera;
        this.periodo = periodo;
        this.comentarios = comentarios;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Educación{" + "ID: " + this.id + ", Institución: " + this.institucion + ", Carrera: " + this.carrera + ", Período: " + this.periodo + ", Comentarios: " + this.comentarios + '}';
    }   
}