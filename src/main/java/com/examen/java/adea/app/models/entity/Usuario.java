package com.examen.java.adea.app.models.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="usuario")
public class Usuario {

	
	@Id
	@Column(nullable = false,columnDefinition = "varchar(20)")
	private String login;
	
	@Column(nullable = false,columnDefinition = "varchar(30)")
	private String password;
	
	@Column(nullable = false,columnDefinition = "varchar(50)")
	private String nombre;
	
	@Column(nullable = false, columnDefinition = "decimal")
	private BigDecimal cliente;
	
	@Column(nullable = true,columnDefinition = "varchar(50)")
	private String email;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaBaja;
	
	@Column(nullable = false, columnDefinition = "char(1) default 'A'")
	private char status;
	
	@Column(nullable = false, columnDefinition = "float default 0")
	private BigDecimal intentos;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRevocado;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaVigencia;
	
	@Column(nullable = true)
	private Integer noAcceso;
	
	@Column(nullable = true,columnDefinition = "varchar(50)")
	private String apellidoPaterno;
	
	@Column(nullable = true,columnDefinition = "varchar(50)")
	private String apellidoMaterno;
	
	@Column(nullable = true,columnDefinition = "int(4)")
	private Integer area;
	
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@Transient
	private String accessToken;

	
	@PrePersist
	public void prePersist() {
		this.fechaAlta = new Date();
		this.fechaModificacion = new Date();
	}
	

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public BigDecimal getCliente() {
		return cliente;
	}


	public void setCliente(BigDecimal cliente) {
		this.cliente = cliente;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFechaAlta() {
		return fechaAlta;
	}


	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	public Date getFechaBaja() {
		return fechaBaja;
	}


	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
	}


	public BigDecimal getIntentos() {
		return intentos;
	}


	public void setIntentos(BigDecimal intentos) {
		this.intentos = intentos;
	}


	public Date getFechaRevocado() {
		return fechaRevocado;
	}


	public void setFechaRevocado(Date fechaRevocado) {
		this.fechaRevocado = fechaRevocado;
	}


	public Date getFechaVigencia() {
		return fechaVigencia;
	}


	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}


	public Integer getNoAcceso() {
		return noAcceso;
	}


	public void setNoAcceso(Integer noAcceso) {
		this.noAcceso = noAcceso;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public Integer getArea() {
		return area;
	}


	public void setArea(Integer area) {
		this.area = area;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if( !(obj instanceof Usuario)) {
			return false;
		}
		Usuario u = (Usuario) obj;
		
		return this.login != null && this.login.equals(u.getLogin());
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	

}
