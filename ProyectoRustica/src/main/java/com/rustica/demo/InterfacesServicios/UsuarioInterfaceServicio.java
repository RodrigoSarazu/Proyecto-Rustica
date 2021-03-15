package com.rustica.demo.InterfacesServicios;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.rustica.demo.modelo.Usuario;

@Repository
public interface UsuarioInterfaceServicio {
	
	public int save(Usuario u);
	public List<Usuario>listarusuario();
	public void delete (int idusu);
	public Usuario buscarPorId(int idusu);
}
