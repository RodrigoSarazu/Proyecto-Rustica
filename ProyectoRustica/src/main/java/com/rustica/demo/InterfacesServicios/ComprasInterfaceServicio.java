package com.rustica.demo.InterfacesServicios;

import java.util.List;
import java.util.Optional;

import com.rustica.demo.modelo.Compras;

public interface ComprasInterfaceServicio {
	public List<Compras>listar();
	public Optional<Compras>listarId(int idcomp);
	public int save (Compras c);
	public void delete (int idcomp);
	public Compras buscarPorId(int idcomp);
}
