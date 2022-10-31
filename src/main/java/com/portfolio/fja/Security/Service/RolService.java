package com.portfolio.fja.Security.Service;

import com.portfolio.fja.Security.Entity.Rol;
import com.portfolio.fja.Security.Enums.TipoDeRol;
import com.portfolio.fja.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    Rol rol;
    
    public Optional<Rol> getByTipoDeRol(TipoDeRol tipoDeRol){
        rol = new Rol(tipoDeRol);
        return iRolRepository.findByTipoDeRol(tipoDeRol);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}