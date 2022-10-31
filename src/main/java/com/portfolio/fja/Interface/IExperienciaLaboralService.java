package com.portfolio.fja.Interface;

import com.portfolio.fja.Entity.ExperienciaLaboral;
import java.util.List;
import java.util.Optional;

public interface IExperienciaLaboralService {
    
    public List<ExperienciaLaboral> list();
    
    public Optional<ExperienciaLaboral> getById(int id);
    
    public void save(ExperienciaLaboral experienciaLaboral);
    
    public void delete(int id);
    
    public boolean existsExperienciaLaboralById(int id);
    
    public boolean existsExperienciaLaboralByCargo(String cargo);
    
    public boolean existsExperienciaLaboralByPeriodo(String periodo);
    
    public boolean existsExperienciaLaboralByEmpresa(String empresa);
}