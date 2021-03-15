package com.rustica.demo.InterfacesServicios;

import java.util.List;

import com.rustica.demo.modelo.Orden_Pago;

public interface Orden_PagoInterfaceServicio {
	public List<Orden_Pago>listar();
	public int guardar(Orden_Pago o);
	public Orden_Pago buscarPorId(int idord);
	public void eliminar(int idord);
}
