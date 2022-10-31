package com.portfolio.fja.Repository;

import com.portfolio.fja.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer>{

    public Optional<Proyecto> findByNombre(String nombre);
    
    public Optional<Proyecto> findByPeriodo(String periodo);

    public boolean existsByNombre(String nombre);
    
    public boolean existsByPeriodo(String periodo);
}