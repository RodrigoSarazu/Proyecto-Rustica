package com.rustica.demo.InterfacesServicios;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.rustica.demo.modelo.Domicilio;
import java.util.Optional;

@Repository
public interface DomicilioInterfaceServicio {
	public List<Domicilio>listar();
	public List<Domicilio>listaradmin();
	public Optional<Domicilio>listarId(int iddomicilio);
	public int save (Domicilio p);
	public void delete(int iddomicilio);
	public Domicilio buscarPorId(int iddomicilio);
}
