package com.rustica.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;  
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id
	private int idusu;
	private String email;
	private String password;
	private String fecha;
	private String nombre;
	private String apellido;
	@Column (name="celular", length = 9)
	private String celular;
	@Column (name="dni", length = 8)
	private String dni;
	
	public Usuario() {
		super();
	}

	public Usuario(int idusu, String email, String password, String fecha, String nombre, String apellido,
			String celular, String dni) {
		super();
		this.idusu = idusu;
		this.email = email;
		this.password = password;
		this.fecha = fecha;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.dni = dni;
	}

	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	
	
	
	
	
	
}
