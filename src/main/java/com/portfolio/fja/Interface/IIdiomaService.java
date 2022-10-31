package com.portfolio.fja.Interface;

import com.portfolio.fja.Entity.Idioma;
import java.util.List;
import java.util.Optional;

public interface IIdiomaService {
    
    public List<Idioma> list();
    
    public Optional<Idioma> getById(int id);
    
    public void save(Idioma idioma);
    
    public void delete(int id);
    
    public boolean existsIdiomaById(int id);
    
    public boolean existsIdiomaByNombre(String nombre);
}