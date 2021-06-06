package com.examen.java.adea.app.contollers;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examen.java.adea.app.models.entity.Usuario;
import com.examen.java.adea.app.services.UsuarioServices;
import io.jsonwebtoken.Jwts;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController <E,S extends UsuarioServices<E>>{
	
	
	@Autowired
	protected S service;
	
	@PostMapping(value= "/login")
	public ResponseEntity <?> login(@RequestBody Usuario usuario){
		String accesToken = getJWTToken(usuario.getLogin());
		Optional<E> o = service.findById(usuario.getLogin());
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Usuario u = (Usuario) o.get();
		u.setAccessToken(accesToken);
		if(u.getPassword().equals(usuario.getPassword())) {
			return ResponseEntity.ok().body(u);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(HttpStatus.UNAUTHORIZED);
		}
		
	}
	@GetMapping(value= "/")
	public ResponseEntity <?> prueba(){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/actualizarPdw")
	public ResponseEntity<?> actualizarPdw(@RequestBody Usuario usuario){
	Optional<E> o = service.findById(usuario.getLogin());
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Usuario dbUsuario =  (Usuario) o.get();
		dbUsuario.setPassword(usuario.getPassword());
		dbUsuario.setFechaModificacion(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save((E) dbUsuario));
	}
	
	
	private String getJWTToken(String username) {
		String secretKey = "pruebaKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("pruebaJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
