package com.diogo.UserManagementApplication.repository;

import com.diogo.UserManagementApplication.entities.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuarios, Long>{

   List<Usuarios> findAll();
   List<Usuarios> findById();

}
