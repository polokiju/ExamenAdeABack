package com.examen.java.adea.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.examen.java.adea.app.models.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

}
