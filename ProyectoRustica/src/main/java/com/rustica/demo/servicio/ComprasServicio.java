package com.rustica.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rustica.demo.InterfacesServicios.ComprasInterfaceServicio;
import com.rustica.demo.interfaces.ComprasInterface;
import com.rustica.demo.modelo.Compras;

@Service
public class ComprasServicio implements ComprasInterfaceServicio{

	@Autowired
	public ComprasInterface data;
	
	@Override
	public List<Compras> listar() {
		return (List<Compras>)data.findAll();
	}

	@Override
	public Optional<Compras> listarId(int idcomp) {
		return data.findById(idcomp);
	}

	@Override
	public int save(Compras c) {
		int res = 0;
		Compras compras = data.save(c);
		if(!compras.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int idcomp) {
		data.deleteById(idcomp);
	}

	@Override
	public Compras buscarPorId(int idcomp) {
		return data.findById(idcomp).orElse(null);
	}
	
}
