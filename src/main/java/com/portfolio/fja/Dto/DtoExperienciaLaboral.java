package com.portfolio.fja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperienciaLaboral {

    @NotBlank
    private String empresa;

    @NotBlank
    private String cargo;

    @NotBlank
    private String periodo;

    @NotBlank
    private String funciones;

    public DtoExperienciaLaboral() {
    }

    public DtoExperienciaLaboral(String empresa, String cargo, String periodo, String funciones) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.periodo = periodo;
        this.funciones = funciones;
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
}