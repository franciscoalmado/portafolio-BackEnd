package com.portfolio.fja.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    
    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String nombre;
        
    @NotNull
    @Size(min = 3, max = 300, message = "No cumple con la longitud")
    private String img;
    
    @NotNull
    private int porcentaje;

    public Skill() {
    }

    public Skill(String img, int porcentaje) {
        this.img = img;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Skill{" + "ID: " + this.id + ", img: " + this.img + ", Porcentaje: " + this.porcentaje + '}';
    }
}