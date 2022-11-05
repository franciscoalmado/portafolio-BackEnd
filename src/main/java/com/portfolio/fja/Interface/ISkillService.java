package com.portfolio.fja.Interface;

import com.portfolio.fja.Entity.Skill;
import java.util.List;
import java.util.Optional;

public interface ISkillService {
    
    public List<Skill> list();
    
    public Optional<Skill> getById(int id);
    
    public Optional<Skill> getByNombre(String nombre);
    
    public void save(Skill skill);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombre(String nombre);
}