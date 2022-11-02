package com.portfolio.fja.Controller;

import com.portfolio.fja.Dto.DtoExperienciaLaboral;
import com.portfolio.fja.Entity.ExperienciaLaboral;
import com.portfolio.fja.Service.ImpExperienciaLaboralService;
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
@RequestMapping(value="/experiencia-laboral", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfolioprueba1-df0a5.web.app")
public class ExperienciaLaboralController {

    @Autowired
    ImpExperienciaLaboralService impExperienciaLaboralService;

    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> listExperienciaLaboral() {
        List<ExperienciaLaboral> listExperienciaLaboral = impExperienciaLaboralService.list();

        return new ResponseEntity(listExperienciaLaboral, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id) {
        if (!impExperienciaLaboralService.existsExperienciaLaboralById(id)) {
            return new ResponseEntity("La experiencia laboral no existe", HttpStatus.NOT_FOUND);
        }

        ExperienciaLaboral experienciaLaboral = impExperienciaLaboralService.getById(id).get();

        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impExperienciaLaboralService.existsExperienciaLaboralById(id)) {
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }

        impExperienciaLaboralService.delete(id);

        return new ResponseEntity("Experiencia laboral eliminada correctamente", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperienciaLaboral dtoExperienciaLaboral) {
        if (StringUtils.isBlank(dtoExperienciaLaboral.getCargo())) {
            return new ResponseEntity("El campo Cargo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExperienciaLaboral.getFunciones())) {
            return new ResponseEntity("El campo Período es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExperienciaLaboral.getFunciones())) {
            return new ResponseEntity("El campo Funciones es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (impExperienciaLaboralService.existsExperienciaLaboralByCargo(dtoExperienciaLaboral.getCargo())) {
            return new ResponseEntity("El cargo ya existe", HttpStatus.BAD_REQUEST);
        }
        if (impExperienciaLaboralService.existsExperienciaLaboralByPeriodo(dtoExperienciaLaboral.getPeriodo())) {
            return new ResponseEntity("EL período ya existe", HttpStatus.BAD_REQUEST);
        }

        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoExperienciaLaboral.getEmpresa(), dtoExperienciaLaboral.getCargo(), dtoExperienciaLaboral.getPeriodo(), dtoExperienciaLaboral.getFunciones());

        impExperienciaLaboralService.save(experienciaLaboral);

        return new ResponseEntity("Experiencia laboral agregada correctamente", HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperienciaLaboral dtoExperienciaLaboral) {
        if (!impExperienciaLaboralService.existsExperienciaLaboralById(id)) {
            return new ResponseEntity("El ID no existe", HttpStatus.BAD_REQUEST);
        }
        if (impExperienciaLaboralService.getByEmpresa(dtoExperienciaLaboral.getEmpresa()).get().getId() != id && impExperienciaLaboralService.getByCargo(dtoExperienciaLaboral.getCargo()).get().getId() != id && impExperienciaLaboralService.getByPeriodo(dtoExperienciaLaboral.getPeriodo()).get().getId() != id) {
            return new ResponseEntity("La experiencia laboral ya existe", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExperienciaLaboral.getEmpresa())) {
            return new ResponseEntity("El campo Empresa es obligatorio", HttpStatus.BAD_REQUEST);
        } 
        if (StringUtils.isBlank(dtoExperienciaLaboral.getCargo())) {
            return new ResponseEntity("El campo Cargo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExperienciaLaboral.getPeriodo())) {
            return new ResponseEntity("El campo Período es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExperienciaLaboral.getFunciones())) {
            return new ResponseEntity("El campo Funciones es obligatorio", HttpStatus.BAD_REQUEST);
        }

        ExperienciaLaboral experienciaLaboral = impExperienciaLaboralService.getById(id).get();

        experienciaLaboral.setEmpresa(dtoExperienciaLaboral.getEmpresa());
        experienciaLaboral.setCargo(dtoExperienciaLaboral.getCargo());
        experienciaLaboral.setPeriodo(dtoExperienciaLaboral.getPeriodo());
        experienciaLaboral.setFunciones(dtoExperienciaLaboral.getFunciones());

        impExperienciaLaboralService.save(experienciaLaboral);

        return new ResponseEntity("Experiencia laboral actualizada correctamente", HttpStatus.OK);
    }
}