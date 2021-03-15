package com.rustica.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Domicilio {
	
	@Id
	private int iddomicilio;
	
	private int idusu;
	
	private String calle;
	
	private String estado;
	
	private String ciudad;

	private String distrito;
	
	public Domicilio() {
		
	}

	public Domicilio(int iddomicilio, int idusu, String calle, String estado, String ciudad, String distrito) {
		super();
		this.iddomicilio = iddomicilio;
		this.idusu = idusu;
		this.calle = calle;
		this.estado = estado;
		this.ciudad = ciudad;
		this.distrito = distrito;
	}

	public int getIddomicilio() {
		return iddomicilio;
	}

	public void setIddomicilio(int iddomicilio) {
		this.iddomicilio = iddomicilio;
	}

	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	
}
