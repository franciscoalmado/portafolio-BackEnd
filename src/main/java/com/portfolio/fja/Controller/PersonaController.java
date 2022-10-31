package com.portfolio.fja.Controller;

import com.portfolio.fja.Dto.DtoPersona;
import com.portfolio.fja.Entity.Persona;
import com.portfolio.fja.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping(value="/personas", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/list")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = impPersonaService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable int id){
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }
        
        Persona persona = impPersonaService.findById(id).get();
        
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getApellido())){
            return new ResponseEntity("El campo Apellido es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getImg())){
            return new ResponseEntity("El campo Img es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getProfesion())){
            return new ResponseEntity("El campo Profesión es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getAboutMe())){
            return new ResponseEntity("El campo About Me es obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(dtoPersona.getNombre(), dtoPersona.getApellido(), dtoPersona.getImg(), dtoPersona.getProfesion(), dtoPersona.getAboutMe());
        
        impPersonaService.savePersona(persona);
        
        return new ResponseEntity("Persona creada correctamente", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }
        
        impPersonaService.deletePersona(id);
        
        return new ResponseEntity("Persona eliminada correctamente", HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody DtoPersona dtoPersona) {
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtoPersona.getNombre())){
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getApellido())){
            return new ResponseEntity("El campo Apellido es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getImg())){
            return new ResponseEntity("El campo Img es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getProfesion())){
            return new ResponseEntity("El campo Profesión es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPersona.getAboutMe())){
            return new ResponseEntity("El campo About Me es obligatorio", HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.findById(id).get();
        
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setImg(dtoPersona.getImg());
        persona.setProfesion(dtoPersona.getProfesion());
        persona.setAboutMe(dtoPersona.getAboutMe());
        
        return new ResponseEntity("Persona actualizada correctamente", HttpStatus.OK);
    }
}