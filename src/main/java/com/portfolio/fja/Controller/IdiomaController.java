package com.portfolio.fja.Controller;

import com.portfolio.fja.Dto.DtoIdioma;
import com.portfolio.fja.Entity.Idioma;
import com.portfolio.fja.Service.ImpIdiomaService;
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
@RequestMapping(value="/idiomas", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = {"https://portfoliofja-68b40.web.app", "http://localhost:4200"})
public class IdiomaController {

    @Autowired
    ImpIdiomaService impIdiomaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Idioma>> listIdiomas() {
        List<Idioma> listIdiomas = impIdiomaService.list();

        return new ResponseEntity(listIdiomas, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable("id") int id) {
        if (!impIdiomaService.existsIdiomaById(id)) {
            return new ResponseEntity("El idioma no existe", HttpStatus.NOT_FOUND);
        }

        Idioma idioma = impIdiomaService.getById(id).get();

        return new ResponseEntity(idioma, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impIdiomaService.existsIdiomaById(id)) {
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }

        impIdiomaService.delete(id);

        return new ResponseEntity("Idioma eliminado correctamente", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoIdioma dtoIdioma) {
        if(StringUtils.isBlank(dtoIdioma.getNombre())){
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
       
        if (impIdiomaService.existsIdiomaByNombre(dtoIdioma.getNombre())) {
            return new ResponseEntity("El nombre del idioma ya existe", HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = new Idioma(dtoIdioma.getNombre(), dtoIdioma.getNivelDeIdioma());
        
        impIdiomaService.save(idioma);
        
        return new ResponseEntity("Idioma agregado correctamente", HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoIdioma dtoIdioma){
        if (impIdiomaService.getByNombre(dtoIdioma.getNombre()).get().getId() != id) {
            return new ResponseEntity("El nombre del idioma ya existe", HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = impIdiomaService.getById(id).get();
        
        idioma.setNombre(dtoIdioma.getNombre());
        idioma.setNivelDeIdioma(dtoIdioma.getNivelDeIdioma());
        
        impIdiomaService.save(idioma);
        
        return new ResponseEntity("Idioma actualizado correctamente", HttpStatus.OK);
    }   
}