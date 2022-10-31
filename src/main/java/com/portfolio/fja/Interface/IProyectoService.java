package com.portfolio.fja.Interface;

import com.portfolio.fja.Entity.Proyecto;
import java.util.List;
import java.util.Optional;

public interface IProyectoService {

    public List<Proyecto> list();
    
    public Optional<Proyecto> getById(int id);
    
    public void save(Proyecto proyecto);
    
    public void delete(int id);
    
    boolean existsProyectoById(int id);
    
    boolean existsProyectoByNombre(String nombre);
}