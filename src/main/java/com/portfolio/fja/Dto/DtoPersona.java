package com.portfolio.fja.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {

    @NotBlank
    private String nombre; 
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String img;
    
    @NotBlank
    private String profesion;
    
    @NotBlank
    private String aboutMe;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String img, String profesion, String aboutMe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.profesion = profesion;
        this.aboutMe = aboutMe;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getAboutMe() {
        return this.aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "DtoPersona{" + "Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", img: " + this.img + ", Profesión: " + this.profesion + ", About me: " + this.aboutMe + '}';
    }
}