package com.rustica.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compras {
	@Id
	public int idcomp;
	@ManyToOne
	@JoinColumn(name="idprov")
	public Proveedor nomprove;
	public String descripcion;
	public int precio;
	public int cantidad;
	
	public Compras(){
		super();
	}

	public Compras(int idcomp, Proveedor nomprove, String descripcion, int precio, int cantidad) {
		super();
		this.idcomp = idcomp;
		this.nomprove = nomprove;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getIdcomp() {
		return idcomp;
	}

	public void setIdcomp(int idcomp) {
		this.idcomp = idcomp;
	}

	public Proveedor getNomprove() {
		return nomprove;
	}

	public void setNomprove(Proveedor nomprove) {
		this.nomprove = nomprove;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

		
}
