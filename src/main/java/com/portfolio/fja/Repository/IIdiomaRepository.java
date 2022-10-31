package com.portfolio.fja.Repository;

import com.portfolio.fja.Entity.Idioma;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIdiomaRepository extends JpaRepository<Idioma, Integer> {
   
    public Optional<Idioma> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}