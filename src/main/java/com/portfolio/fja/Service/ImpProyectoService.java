package com.portfolio.fja.Service;

import com.portfolio.fja.Entity.Proyecto;
import com.portfolio.fja.Interface.IProyectoService;
import com.portfolio.fja.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService implements IProyectoService {

    @Autowired
    IProyectoRepository iProyectoRepository;

    @Override
    public List<Proyecto> list() {
        return iProyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> getById(int id) {
        return iProyectoRepository.findById(id);
    }

    @Override
    public void save(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    @Override
    public void delete(int id) {
        iProyectoRepository.deleteById(id);
    }

    @Override
    public boolean existsProyectoById(int id) {
        return iProyectoRepository.existsById(id);
    }

    @Override
    public boolean existsProyectoByNombre(String nombre) {
        return iProyectoRepository.existsByNombre(nombre);
    }
    
    public Optional<Proyecto> getByNombre(String nombre){
        return iProyectoRepository.findByNombre(nombre);
    }
    
    public Optional<Proyecto> getByPeriodo(String periodo){
        return iProyectoRepository.findByPeriodo(periodo);
    }
    
    public boolean existsByPeriodo(String periodo) {
        return iProyectoRepository.existsByPeriodo(periodo);
    }
}