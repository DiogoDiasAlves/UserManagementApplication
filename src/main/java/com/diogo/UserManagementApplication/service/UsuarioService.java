package com.diogo.UserManagementApplication.service;

import com.diogo.UserManagementApplication.entities.Usuarios;
import com.diogo.UserManagementApplication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuarios salvar(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }
    public void deletar(Usuarios usuario){
         usuarioRepository.delete(usuario);

    }

}
