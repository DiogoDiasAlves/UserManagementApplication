package com.diogo.UserManagementApplication.controller;

import com.diogo.UserManagementApplication.entities.Usuarios;
import com.diogo.UserManagementApplication.repository.UsuarioRepository;
import com.diogo.UserManagementApplication.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dominio")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("v1/api/usuarios")
    public ResponseEntity<Usuarios> salvar(@RequestBody Usuarios usuario){
        Usuarios usuarioSalvo = usuarioService.salvar(usuario);
        return ResponseEntity.status(201).body(usuarioSalvo);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("v1/api/usuarios")
    public ResponseEntity<List<Usuarios>> ListasUsuarios(){
        List<Usuarios> usuarioListar= usuarioRepository.findAll();
        return ResponseEntity.status(200).body(usuarioListar);
    }
    @GetMapping("v1/api/usuarios/{id}")
    public ResponseEntity<Optional<Usuarios>> buscaId(@PathVariable Long id){
        Optional<Usuarios> usuarioID = usuarioRepository.findById(id);
                return ResponseEntity.status(200).body(usuarioID);
    }

    @PutMapping("v1/api/usuarios/{id}")
    public ResponseEntity<Usuarios> editar(@RequestBody Usuarios usuario){
        Usuarios usuarioSalvo = usuarioService.salvar(usuario);
        return ResponseEntity.status(201).body(usuarioSalvo);
    }
    @DeleteMapping("v1/api/usuarios/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioService.deletar(usuarioOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }




}
