package com.rustica.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Proveedor {
	@Id
	private int idprov;
	private String nomprove;
	private String nombrecontac;
	private String telefono;	
	private String direccion;
	private String codpostal;
	
	public Proveedor() {
		super();
	}

	public Proveedor(int idprov, String nomprove, String nombrecontac, String telefono, String direccion,
			String codpostal) {
		super();
		this.idprov = idprov;
		this.nomprove = nomprove;
		this.nombrecontac = nombrecontac;
		this.telefono = telefono;
		this.direccion = direccion;
		this.codpostal = codpostal;
	}

	public int getIdprov() {
		return idprov;
	}

	public void setIdprov(int idprov) {
		this.idprov = idprov;
	}

	public String getNomprove() {
		return nomprove;
	}

	public void setNomprove(String nomprove) {
		this.nomprove = nomprove;
	}

	public String getNombrecontac() {
		return nombrecontac;
	}

	public void setNombrecontac(String nombrecontac) {
		this.nombrecontac = nombrecontac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}
	
}
