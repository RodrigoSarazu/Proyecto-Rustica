package com.rustica.demo.InterfacesServicios;

import java.util.List;
import java.util.Optional;

import com.rustica.demo.modelo.Userrustica;

public interface UserrusticaInterfaceServicio {
	public List<Userrustica>listaradmin();
	public Optional<Userrustica>listarId(int user_id);
	public int save (Userrustica p);
	public void delete(int user_id);
}
