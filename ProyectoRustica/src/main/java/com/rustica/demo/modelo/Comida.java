package com.rustica.demo.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Comida {	
	@Id
	private int idcom;
	private String nombre;
	private double precio;
	private String fecha;	
	private String imagen;
	public Comida() {
		super();
	}
	public Comida(int idcom, String nombre, double precio, String fecha, String imagen) {
		super();
		this.idcom = idcom;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
		this.imagen = imagen;
	}
	public int getIdcom() {
		return idcom;
	}
	public void setIdcom(int idcom) {
		this.idcom = idcom;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	
	
	
}
