package com.rustica.demo.InterfacesServicios;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.rustica.demo.modelo.Proveedor;

@Repository
public interface ProveedorInterfaceServicio {
	
	public List<Proveedor>listar();
	public Optional<Proveedor>listarId(int idprov);
	public int save (Proveedor p);
	public void delete(int idprov);
	public Proveedor buscarporId(int idprov);

}
