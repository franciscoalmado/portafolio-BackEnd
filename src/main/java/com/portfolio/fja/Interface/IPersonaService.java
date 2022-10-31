package com.portfolio.fja.Interface;

import com.portfolio.fja.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    public List<Persona> list();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(int id);
    
    public Persona findPersona(int id);
}