package com.portfolio.fja.Service;

import com.portfolio.fja.Entity.Educacion;
import com.portfolio.fja.Interface.IEducacionService;
import com.portfolio.fja.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService implements IEducacionService{

    @Autowired
    IEducacionRepository iEducacionRepository;

    @Override
    public List<Educacion> list() {
        return iEducacionRepository.findAll();
    }

    @Override
    public Optional<Educacion> getById(int id) {
        return iEducacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByCarrera(String carrera){
        return iEducacionRepository.findByCarrera(carrera);
    }
    
    public Optional<Educacion> getByInstitucion(String institucion){
        return iEducacionRepository.findByInstitucion(institucion);
    }
    
    public Optional<Educacion> getByPeriodo(String periodo){
        return iEducacionRepository.findByPeriodo(periodo);
    }

    @Override
    public void save(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public void delete(int id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public boolean existsEducacionById(int id) {
        return iEducacionRepository.existsById(id);
    }

    @Override
    public boolean existsEducacionByCarrera(String carrera) {
        return iEducacionRepository.existsByCarrera(carrera);
    }   

    @Override
    public boolean existsEducacionByInstitucion(String institucion) {
        return iEducacionRepository.existsByInstitucion(institucion);
    }

    @Override
    public boolean existsEducacionByPeriodo(String periodo) {
        return iEducacionRepository.existsByPeriodo(periodo);
    }
}