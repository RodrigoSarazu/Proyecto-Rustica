package com.rustica.demo.InterfacesServicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.rustica.demo.modelo.Comida;

@Repository
public interface ComidaInterfaceServicio {
	public List<Comida>listar();
	public List<Comida>listaradmin();
	public Optional<Comida>listarId(int idcom);
	public int save (Comida p);
	public void delete(int idcom);
	public Comida buscarPorId(int idcom);
	
}
