package com.rustica.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rustica.demo.InterfacesServicios.Metodo_PagoIntefaceServicio;
import com.rustica.demo.interfaces.Metodo_PagoInterface;
import com.rustica.demo.modelo.Metodo_Pago;

@Service
public class Metodo_PagoServicio implements Metodo_PagoIntefaceServicio{

	@Autowired
	Metodo_PagoInterface data;
	
	@Override
	public List<Metodo_Pago> listar() {
		return (List<Metodo_Pago>)data.findAll();
	}

}
