package com.portfolio.fja.Service;

import com.portfolio.fja.Entity.Skill;
import com.portfolio.fja.Interface.ISkillService;
import com.portfolio.fja.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSkillService implements ISkillService {
    
    @Autowired
    ISkillRepository iSkillRepository;

    @Override
    public List<Skill> list() {
        return iSkillRepository.findAll();
    }

    @Override
    public Optional<Skill> getById(int id) {
        return iSkillRepository.findById(id);
    }

    @Override
    public void save(Skill skill) {
        iSkillRepository.save(skill);
    }

    @Override
    public void delete(int id) {
        iSkillRepository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return iSkillRepository.existsById(id);
    }

    @Override
    public Optional<Skill> getByNombre(String nombre) {
        return iSkillRepository.findByNombre(nombre);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return iSkillRepository.existsByNombre(nombre);
    }
}