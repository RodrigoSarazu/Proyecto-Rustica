package com.rustica.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	private int idticket;
	private int idusu;
	@ManyToOne
	@JoinColumn(name="idcom")
	private Comida nombre;
	private int cantidad;
	private String fechaped;
	private String fechaent;
	
	public Ticket() {
		super();
	}

	public Ticket(int idticket, int idusu, Comida nombre, int cantidad, String fechaped, String fechaent) {
		super();
		this.idticket = idticket;
		this.idusu = idusu;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaped = fechaped;
		this.fechaent = fechaent;
	}

	public int getIdticket() {
		return idticket;
	}

	public void setIdticket(int idticket) {
		this.idticket = idticket;
	}

	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public Comida getNombre() {
		return nombre;
	}

	public void setNombre(Comida nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaped() {
		return fechaped;
	}

	public void setFechaped(String fechaped) {
		this.fechaped = fechaped;
	}

	public String getFechaent() {
		return fechaent;
	}

	public void setFechaent(String fechaent) {
		this.fechaent = fechaent;
	}

	
	
}
