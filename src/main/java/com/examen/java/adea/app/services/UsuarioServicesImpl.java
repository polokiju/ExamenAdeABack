package com.examen.java.adea.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.java.adea.app.models.entity.Usuario;


@Service
public class UsuarioServicesImpl <Usuario,R extends CrudRepository<Usuario, String>> implements UsuarioServices<Usuario> {

	@Autowired
	protected R repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(String login) {
		// TODO Auto-generated method stub
		return repository.findById(login);
	}

	@Override
	@Transactional
	public Usuario save(Usuario e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

	@Override
	@Transactional
	public void deleteById(String login) {
		repository.deleteById(login);
	}

}
