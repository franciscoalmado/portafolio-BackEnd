package com.portfolio.fja.Repository;

import com.portfolio.fja.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer> {
 
    public Optional<Educacion> findByCarrera(String carrera);
    
    public boolean existsByCarrera(String carrera);
    
    public Optional<Educacion> findByInstitucion(String institucion);
    
    public boolean existsByInstitucion(String institucion);
    
    public Optional<Educacion> findByPeriodo(String periodo);
    
    public boolean existsByPeriodo(String periodo);
}