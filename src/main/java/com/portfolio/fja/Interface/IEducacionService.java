package com.portfolio.fja.Interface;

import com.portfolio.fja.Entity.Educacion;
import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    
    public List<Educacion> list();
    
    public Optional<Educacion> getById(int id);
    
    public void save(Educacion educacion);
    
    public void delete(int id);
    
    public boolean existsEducacionById(int id);
    
    public boolean existsEducacionByCarrera(String carrera);
    
    public boolean existsEducacionByInstitucion(String carrera);
    
    public boolean existsEducacionByPeriodo(String periodo);
}