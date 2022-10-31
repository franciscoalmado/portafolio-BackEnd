package com.portfolio.fja.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String empresa;
    
    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String cargo;
    
    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String periodo;
    
    @NotNull
    @Size(min = 3, max = 600, message = "No cumple con la longitud")
    private String funciones;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String empresa, String cargo, String periodo, String funciones) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.periodo = periodo;
        this.funciones = funciones;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFunciones() {
        return this.funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    @Override
    public String toString() {
        return "ExperienciaLaboral{" + "ID: " + this.id + ", Empresa: " + this.empresa + ", Cargo: " + this.cargo + ", Período: " + this.periodo + ", Funciones: " + this.funciones + '}';
    }
}