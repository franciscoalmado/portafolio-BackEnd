package com.portfolio.fja.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String apellido;
    
    @NotNull
    @Size(min = 3, max = 300, message = "No cumple con la longitud")
    private String img;
    
    @NotNull
    @Size(min = 3, max = 50, message = "No cumple con la longitud")
    private String profesion;
    
    @NotNull
    @Size(min = 1, max = 600, message = "No cumple con la longitud")
    private String aboutMe;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String profesion, String aboutMe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.profesion = profesion;
        this.aboutMe = aboutMe;
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
    
    public String getProfesion(){
        return this.profesion;
    }
    
    public void setProfesion(String profesion){
        this.profesion = profesion;
    }
    
    public String getAboutMe(){
        return this.aboutMe;
    }
    
    public void setAboutMe(String aboutMe){
        this.aboutMe = aboutMe;
    }
}