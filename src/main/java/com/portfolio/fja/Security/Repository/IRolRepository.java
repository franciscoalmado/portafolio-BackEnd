package com.portfolio.fja.Security.Repository;

import com.portfolio.fja.Security.Entity.Rol;
import com.portfolio.fja.Security.Enums.TipoDeRol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByTipoDeRol(TipoDeRol tipoDeRol);
}