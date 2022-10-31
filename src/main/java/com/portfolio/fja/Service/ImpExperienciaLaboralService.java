package com.portfolio.fja.Service;

import com.portfolio.fja.Entity.ExperienciaLaboral;
import com.portfolio.fja.Interface.IExperienciaLaboralService;
import com.portfolio.fja.Repository.IExperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired
    IExperienciaLaboralRepository iExperienciaLaboralRepository;

    @Override
    public List<ExperienciaLaboral> list() {
        return iExperienciaLaboralRepository.findAll();
    }

    @Override
    public Optional<ExperienciaLaboral> getById(int id) {
        return iExperienciaLaboralRepository.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByCargo(String cargo){
        return iExperienciaLaboralRepository.findByCargo(cargo);
    }
    
    public Optional<ExperienciaLaboral> getByEmpresa(String empresa){
        return iExperienciaLaboralRepository.findByEmpresa(empresa);
    }
    
    public Optional<ExperienciaLaboral> getByPeriodo(String periodo){
        return iExperienciaLaboralRepository.findByPeriodo(periodo);
    }

    @Override
    public void save(ExperienciaLaboral experienciaLaboral) {
        iExperienciaLaboralRepository.save(experienciaLaboral);
    }

    @Override
    public void delete(int id) {
        iExperienciaLaboralRepository.deleteById(id);
    }

    @Override
    public boolean existsExperienciaLaboralById(int id) {
        return iExperienciaLaboralRepository.existsById(id);
    }

    @Override
    public boolean existsExperienciaLaboralByCargo(String cargo) {
        return iExperienciaLaboralRepository.existsByCargo(cargo);
    }

    @Override
    public boolean existsExperienciaLaboralByPeriodo(String periodo) {
        return iExperienciaLaboralRepository.existsByPeriodo(periodo);
    }

    @Override
    public boolean existsExperienciaLaboralByEmpresa(String empresa) {
        return iExperienciaLaboralRepository.existsByEmpresa(empresa);
    }
}