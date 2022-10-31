package com.portfolio.fja.Controller;

import com.portfolio.fja.Dto.DtoEducacion;
import com.portfolio.fja.Entity.Educacion;
import com.portfolio.fja.Service.ImpEducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/educacion", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = "https://portfolio-fja-prueba.web.app")
public class EducacionController {
    
    @Autowired
    ImpEducacionService impEducacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> listEducacion() {
        List<Educacion> listEducacion = impEducacionService.list();

        return new ResponseEntity(listEducacion, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!impEducacionService.existsEducacionById(id)) {
            return new ResponseEntity("La educación no existe", HttpStatus.NOT_FOUND);
        }

        Educacion educacion = impEducacionService.getById(id).get();

        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impEducacionService.existsEducacionById(id)) {
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }

        impEducacionService.delete(id);

        return new ResponseEntity("Educación eliminada correctamente", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion) {
        if (StringUtils.isBlank(dtoEducacion.getInstitucion())) {
            return new ResponseEntity("El campo Institución es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getCarrera())) {
            return new ResponseEntity("El campo Carrera es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getPeriodo())) {
            return new ResponseEntity("El campo Período es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getComentarios())) {
            return new ResponseEntity("El campo Comentarios es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (impEducacionService.existsEducacionByCarrera(dtoEducacion.getCarrera())) {
            return new ResponseEntity("La carrera ya existe", HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoEducacion.getInstitucion(), dtoEducacion.getCarrera(), dtoEducacion.getPeriodo(), dtoEducacion.getComentarios());

        impEducacionService.save(educacion);

        return new ResponseEntity("Educación agregada correctamente", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoEducacion) {
        if (!impEducacionService.existsEducacionById(id)) {
            return new ResponseEntity("El ID no existe", HttpStatus.BAD_REQUEST);
        }
        if (impEducacionService.getByInstitucion(dtoEducacion.getInstitucion()).get().getId() != id && impEducacionService.getByCarrera(dtoEducacion.getCarrera()).get().getId() != id && impEducacionService.getByPeriodo(dtoEducacion.getPeriodo()).get().getId() != id) {
            return new ResponseEntity("La educación ya existe", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getInstitucion())) {
            return new ResponseEntity("El campo Institución es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getCarrera())) {
            return new ResponseEntity("El campo Carrera es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getPeriodo())) {
            return new ResponseEntity("El campo Período es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoEducacion.getComentarios())) {
            return new ResponseEntity("El campo Comentarios es obligatorio", HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = impEducacionService.getById(id).get();
        
        educacion.setInstitucion(dtoEducacion.getInstitucion());
        educacion.setCarrera(dtoEducacion.getCarrera());
        educacion.setPeriodo(dtoEducacion.getPeriodo());
        educacion.setComentarios(dtoEducacion.getComentarios());
        
        impEducacionService.save(educacion);
        
        return new ResponseEntity("Educación actualizada correctamente", HttpStatus.OK);       
    }
}