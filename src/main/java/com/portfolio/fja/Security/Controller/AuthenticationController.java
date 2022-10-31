package com.portfolio.fja.Security.Controller;

import com.portfolio.fja.Security.Dto.JwtDto;
import com.portfolio.fja.Security.Dto.LoginUsuario;
import com.portfolio.fja.Security.Dto.NuevoUsuario;
import com.portfolio.fja.Security.Entity.Rol;
import com.portfolio.fja.Security.Entity.Usuario;
import com.portfolio.fja.Security.Enums.TipoDeRol;
import com.portfolio.fja.Security.Jwt.JwtProvider;
import com.portfolio.fja.Security.Service.RolService;
import com.portfolio.fja.Security.Service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByUsername(nuevoUsuario.getUsername())){
            return new ResponseEntity(new Mensaje("El username usado ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByUsername(nuevoUsuario.getEmail())){
            return new ResponseEntity(new Mensaje("El email usado ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getEmail(), nuevoUsuario.getUsername(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        
        roles.add(rolService.getByTipoDeRol(TipoDeRol.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("ROLE_ADMIN")){
            roles.add(rolService.getByTipoDeRol(TipoDeRol.ROLE_ADMIN).get());
        }
        
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Mensaje("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}