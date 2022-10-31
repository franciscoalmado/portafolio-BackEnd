package com.portfolio.fja.Repository;

import com.portfolio.fja.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{

    public Optional<Persona> getByNombre(String nombre);
    
    public boolean existsById(int id);
    
    public Optional<Persona> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
    
    public Optional<Persona> findByApellido(String apellido);
    
    public boolean existsByApellido(String apellido);
    
    public Optional<Persona> findByProfesion(String profesion);
    
    public boolean existsByProfesion(String profesion);
}