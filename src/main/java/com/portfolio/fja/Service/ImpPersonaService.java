package com.portfolio.fja.Service;

import com.portfolio.fja.Entity.Persona;
import com.portfolio.fja.Interface.IPersonaService;
import com.portfolio.fja.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {
    @Autowired 
    IPersonaRepository iPersonaRepository; 
    
    @Override
    public List<Persona> list() {
        List<Persona> personas = iPersonaRepository.findAll();
        return personas;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
    public Optional<Persona> findById(int id){
        return iPersonaRepository.findById(id);
    }
    
    public Optional<Persona> findByNombre(String nombre){
        return iPersonaRepository.findByNombre(nombre);
    }
    
    public Optional<Persona> findByApellido(String apellido){
        return iPersonaRepository.findByApellido(apellido);
    }
    
    public Optional<Persona> findByProfesion(String profesion){
        return iPersonaRepository.findByApellido(profesion);
    }
    
    public boolean existsByNombre(String nombre){
        return iPersonaRepository.existsByNombre(nombre);
    }
    
    public boolean existsByApellido(String apellido){
        return iPersonaRepository.existsByNombre(apellido);
    }
    
    public boolean existsById(int id){
        return iPersonaRepository.existsById(id);
    }
    
    public boolean existsByProfesion(String profesion){
        return iPersonaRepository.existsByProfesion(profesion);
    }
}