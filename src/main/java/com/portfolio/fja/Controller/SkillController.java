package com.portfolio.fja.Controller;

import com.portfolio.fja.Dto.DtoSkill;
import com.portfolio.fja.Entity.Skill;
import com.portfolio.fja.Service.ImpSkillService;
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
@RequestMapping(value="/skill", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@CrossOrigin(origins = {"https://portfoliofja-68b40.web.app", "http://localhost:4200"})
public class SkillController {
    
    @Autowired
    ImpSkillService impSkillService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> listSkill(){
        List<Skill> listSkill = impSkillService.list();
        
        return new ResponseEntity(listSkill, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!impSkillService.existsById(id)){
            return new ResponseEntity("La skill no existe", HttpStatus.NOT_FOUND);
        }
        
        Skill skill = impSkillService.getById(id).get();
        
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if(!impSkillService.existsById(id)){
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }
    
        impSkillService.delete(id);
        
        return new ResponseEntity("Skill eliminada correctamente", HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombre())){
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getImg())){
            return new ResponseEntity("El campo Img es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(impSkillService.existsByNombre(dtoSkill.getNombre())){
            return new ResponseEntity("La skill ya existe", HttpStatus.BAD_REQUEST);
        }
        if(dtoSkill.getPorcentaje() <= 0){
            return new ResponseEntity("El campo Porcentaje debe tener un valor válido", HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = new Skill(dtoSkill.getImg(), dtoSkill.getPorcentaje());
        
        impSkillService.save(skill);
        
        return new ResponseEntity("Skill agregada correctamente", HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getNombre())){
            return new ResponseEntity("El campo Nombre es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSkill.getImg())){
            return new ResponseEntity("El campo Img es obligatorio", HttpStatus.BAD_REQUEST);
        }
        if(!impSkillService.existsById(id)){
            return new ResponseEntity("El ID no existe", HttpStatus.NOT_FOUND);
        }
        if(impSkillService.existsByNombre(dtoSkill.getNombre())){
            return new ResponseEntity("La skill ya existe", HttpStatus.BAD_REQUEST);
        }
        if(impSkillService.getByNombre(dtoSkill.getNombre()).get().getId() != id && impSkillService.getByNombre(dtoSkill.getImg()).get().getId() != id){
            return new ResponseEntity("La skill ya existe", HttpStatus.BAD_REQUEST);
        }
        if(dtoSkill.getPorcentaje() <= 0){
            return new ResponseEntity("El campo Porcentaje debe tener un valor válido", HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = impSkillService.getById(id).get();
        
        skill.setNombre(dtoSkill.getNombre());
        skill.setImg(dtoSkill.getImg());
        skill.setPorcentaje(dtoSkill.getPorcentaje());
        
        return new ResponseEntity("Skill actualizada correctamente", HttpStatus.OK); 
    }
}