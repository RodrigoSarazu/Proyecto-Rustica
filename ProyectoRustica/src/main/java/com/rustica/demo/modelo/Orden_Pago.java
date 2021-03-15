package com.rustica.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orden_pago")
public class Orden_Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idord;
	private int idusu;
	@ManyToOne
	@JoinColumn(name="idmep")
	private Metodo_Pago metodopago;
	private double total;
	@ManyToOne
	@JoinColumn(name="iddomicilio")
	private Domicilio calle;
	
	public Orden_Pago() {
		super();
	}

	public Orden_Pago(int idord, int idusu, Metodo_Pago metodopago, double total, Domicilio calle) {
		super();
		this.idord = idord;
		this.idusu = idusu;
		this.metodopago = metodopago;
		this.total = total;
		this.calle = calle;
	}

	public int getIdord() {
		return idord;
	}

	public void setIdord(int idord) {
		this.idord = idord;
	}

	public int getIdusu() {
		return idusu;
	}

	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}

	public Metodo_Pago getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(Metodo_Pago metodopago) {
		this.metodopago = metodopago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Domicilio getCalle() {
		return calle;
	}

	public void setCalle(Domicilio calle) {
		this.calle = calle;
	}
	

	

	
	

	
	
}
