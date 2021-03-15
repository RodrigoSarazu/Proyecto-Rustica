package com.rustica.demo.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="metodo_pago")
public class Metodo_Pago {
	

	@Id
	private int idmep;
	private String metodopago;	
	
	public int getIdmep() {
		return idmep;
	}

	public void setIdmep(int idmep) {
		this.idmep = idmep;
	}

	public String getMetodopago() {
		return metodopago;
	}

	public void setMetodopago(String metodopago) {
		this.metodopago = metodopago;
	}

	@Override
	public String toString() {
		return "metodo_pago [idmep=" + idmep + ", metodopago=" + metodopago + "]";
	}
	
}
