package com.portfolio.fja.Service;

import com.portfolio.fja.Entity.Idioma;
import com.portfolio.fja.Interface.IIdiomaService;
import com.portfolio.fja.Repository.IIdiomaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpIdiomaService implements IIdiomaService{
    
    @Autowired
    IIdiomaRepository iIdiomaRepository;
    
    @Override
    public List<Idioma> list() {
        return iIdiomaRepository.findAll();
    }

    @Override
    public Optional<Idioma> getById(int id) {
        return iIdiomaRepository.findById(id);
    }
    
    public Optional<Idioma> getByNombre(String nombre){
        return iIdiomaRepository.findByNombre(nombre);
    }

    @Override
    public void save(Idioma idioma) {
        iIdiomaRepository.save(idioma);
    }

    @Override
    public void delete(int id) {
        iIdiomaRepository.deleteById(id);
    }

    @Override
    public boolean existsIdiomaById(int id) {
        return iIdiomaRepository.existsById(id);
    }

    @Override
    public boolean existsIdiomaByNombre(String nombre) {
        return iIdiomaRepository.existsByNombre(nombre);
    }   
}