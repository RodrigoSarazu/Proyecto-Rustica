package com.rustica.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rustica.demo.InterfacesServicios.ComidaInterfaceServicio;
import com.rustica.demo.interfaces.ComidaInterface;
import com.rustica.demo.modelo.Comida;

@Service
public class ComidaServicio implements ComidaInterfaceServicio{
	
	@Autowired
	ComidaInterface data;
	
	@Override
	public List<Comida> listar() {
		return (List<Comida>)data.findAll();
	}

	@Override
	public List<Comida> listaradmin() {
		return (List<Comida>)data.findAll();
	}

	@Override
	public Optional<Comida> listarId(int idcom) {
		
		return data.findById(idcom);
	}

	@Override
	public int save(Comida p) {
		int res=0;
		Comida comida=data.save(p);
		if(!comida.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int idcom) {
		data.deleteById(idcom);
		
	}

	@Override
	public Comida buscarPorId(int idcom) {
		return data.findById(idcom).orElse(null);
	}

}
