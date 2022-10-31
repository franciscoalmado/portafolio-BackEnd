package com.portfolio.fja.Repository;

import com.portfolio.fja.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer>{

    public Optional<ExperienciaLaboral> findByCargo(String cargo);
    
    public boolean existsByCargo(String cargo);
    
    public Optional<ExperienciaLaboral> findByEmpresa(String empresa);
    
    public boolean existsByEmpresa(String empresa);
    
    public Optional<ExperienciaLaboral> findByPeriodo(String periodo);
    
    public boolean existsByPeriodo(String periodo);
}