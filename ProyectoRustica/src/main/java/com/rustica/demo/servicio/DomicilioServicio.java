package com.rustica.demo.servicio;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rustica.demo.InterfacesServicios.DomicilioInterfaceServicio;
import com.rustica.demo.interfaces.DomicilioInterface;
import com.rustica.demo.modelo.Domicilio;

@Service
public class DomicilioServicio implements DomicilioInterfaceServicio{

	@Autowired
	DomicilioInterface data;
	
	@Override
	public List<Domicilio> listar() {
		return (List<Domicilio>)data.findAll();
	}

	@Override
	public int save(Domicilio p) {
		int res = 0;
		Domicilio domicilio = data.save(p);
		if(!domicilio.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int iddomicilio) {
		data.deleteById(iddomicilio);		
	}

	@Override
	public List<Domicilio> listaradmin() {
		return (List<Domicilio>)data.findAll();
	}

	@Override
	public Optional<Domicilio> listarId(int iddomicilio) {
		return data.findById(iddomicilio);
	}

	@Override
	public Domicilio buscarPorId(int iddomicilio) {
		return data.findById(iddomicilio).orElse(null);
	}

}
