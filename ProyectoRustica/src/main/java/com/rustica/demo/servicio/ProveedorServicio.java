package com.rustica.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rustica.demo.InterfacesServicios.ProveedorInterfaceServicio;
import com.rustica.demo.interfaces.ProveedorInterface;
import com.rustica.demo.modelo.Proveedor;

@Service
public class ProveedorServicio implements ProveedorInterfaceServicio{

	@Autowired
	ProveedorInterface data;
	
	@Override
	public List<Proveedor> listar() {
		return (List<Proveedor>)data.findAll();
	}

	@Override
	public Optional<Proveedor> listarId(int idprov) {
		return data.findById(idprov);
	}

	@Override
	public int save(Proveedor p) {
		int res=0;
		Proveedor proveedor=data.save(p);
		if(!proveedor.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int idprov) {
		data.deleteById(idprov);
	}

	@Override
	public Proveedor buscarporId(int idprov) {
		return data.findById(idprov).orElse(null);
	}

}
