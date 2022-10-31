package com.portfolio.fja.Security.Entity;

import com.portfolio.fja.Security.Enums.TipoDeRol;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoDeRol tipoDeRol;

    public Rol() {
    }

    public Rol(TipoDeRol tipoDeRol) {
        this.tipoDeRol = tipoDeRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDeRol getTipoDeRol() {
        return tipoDeRol;
    }

    public void setTipoDeRol(TipoDeRol tipoDeRol) {
        this.tipoDeRol = tipoDeRol;
    }
}