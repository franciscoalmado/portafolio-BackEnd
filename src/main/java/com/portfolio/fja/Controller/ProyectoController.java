package com.portfolio.fja.Controller;

import com.portfolio.fja.Dto.DtoProyecto;
import com.portfolio.fja.Entity.Proyecto;
import com.portfolio.fja.Service.ImpProyectoService;
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
@RequestMapping(value = "/proyectos", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = {"https://portfoliofja-68b40.web.app", "http://localhost:4200"})
public class ProyectoController {

    @Autowired
    ImpProyectoService impProyectoService;

    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>> listProyectos() {
        List<Proyecto> listProyectos = impProyectoService.list();

        return new ResponseEntity(listProyectos, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!impProyectoService.existsProyectoById(id)) {
            return new ResponseEntity("El proyecto no existe", HttpStatus.NOT_FOUND);
        }

        Proyecto proyecto = impProyectoService.getById(id).get();

        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impProyectoService.existsProyectoById(id)) {
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }

        impProyectoService.delete(id);

        return new ResponseEntity("Proyecto eliminado correctamente", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {
        if (StringUtils.isBlank(dtoProyecto.getNombre())) {
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getTecnologias())) {
            return new ResponseEntity("El campo Tecnologías es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getPeriodo())) {
            return new ResponseEntity("El campo Período es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getDescripcion())) {
            return new ResponseEntity("El campo Descripción es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (impProyectoService.existsProyectoByNombre(dtoProyecto.getNombre())) {
            return new ResponseEntity("El nombre del proyecto ya existe", HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = new Proyecto(dtoProyecto.getNombre(), dtoProyecto.getTecnologias(), dtoProyecto.getPeriodo(), dtoProyecto.getDescripcion());
        
        impProyectoService.save(proyecto);

        return new ResponseEntity("Proyecto guardado", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {
        if (StringUtils.isBlank(dtoProyecto.getNombre())) {
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getTecnologias())) {
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getPeriodo())) {
            return new ResponseEntity("El campo Período es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getDescripcion())) {
            return new ResponseEntity("El campo Descripción es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if (impProyectoService.getByNombre(dtoProyecto.getNombre()).get().getId() != id && impProyectoService.getByPeriodo(dtoProyecto.getPeriodo()).get().getId() != id) {
            return new ResponseEntity("El nombre del proyecto ya existe", HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = impProyectoService.getById(id).get();

        proyecto.setNombre(dtoProyecto.getNombre());
        proyecto.setTecnologias(dtoProyecto.getTecnologias());
        proyecto.setPeriodo(dtoProyecto.getPeriodo());
        proyecto.setDescripcion(dtoProyecto.getDescripcion());

        impProyectoService.save(proyecto);

        return new ResponseEntity("Proyecto actualizado correctamente", HttpStatus.OK);
    }
}