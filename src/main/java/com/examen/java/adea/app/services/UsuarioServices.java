package com.examen.java.adea.app.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.java.adea.app.models.entity.Usuario;



@SuppressWarnings("hiding")
public interface UsuarioServices <Usuario> {
	
	public Iterable<Usuario> findAll();
	
	public Optional<Usuario> findById(String login);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(String login);
}
