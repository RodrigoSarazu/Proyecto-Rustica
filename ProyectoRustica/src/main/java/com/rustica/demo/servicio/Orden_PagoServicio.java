package com.rustica.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rustica.demo.InterfacesServicios.Orden_PagoInterfaceServicio;
import com.rustica.demo.interfaces.Orden_PagoInterfaces;
import com.rustica.demo.modelo.Orden_Pago;

@Service
public class Orden_PagoServicio implements Orden_PagoInterfaceServicio{

	@Autowired
	Orden_PagoInterfaces data;
	
	@Override
	public List<Orden_Pago> listar() {
		
		return (List<Orden_Pago>)data.findAll();
	}

	@Override
	public int guardar(Orden_Pago o) {
		int res=0;
		Orden_Pago orden=data.save(o);
		if(!orden.equals(null)) {
			res=1;
		}
		return res;
		
		
	}

	@Override
	public Orden_Pago buscarPorId(int idord) {
		return data.findById(idord).orElse(null);
	}

	@Override
	public void eliminar(int idord) {
		data.deleteById(idord);
		
	}
	
}
