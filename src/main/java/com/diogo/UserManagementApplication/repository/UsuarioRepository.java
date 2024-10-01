package com.diogo.UserManagementApplication.repository;

import com.diogo.UserManagementApplication.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuarios, Long>{


   List<Usuarios> findAll();
   Optional<Usuarios> findById(Long id);
   Optional<Usuarios> findByName(String name);

}
