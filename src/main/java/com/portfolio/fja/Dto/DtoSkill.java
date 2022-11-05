package com.portfolio.fja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoSkill {

    @NotBlank
    private String nombre;
    
    @NotBlank
    private String img;
    
    private int porcentaje;

    public DtoSkill() {
    }

    public DtoSkill(String img, int porcentaje) {
        this.img = img;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "DtoSkill{" + "img: " + this.img + ", Porcentaje: " + this.porcentaje + '}';
    }
}