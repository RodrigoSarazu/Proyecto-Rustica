package com.rustica.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.rustica.demo.interfaces.UsuarioInterface;
import com.rustica.demo.InterfacesServicios.UsuarioInterfaceServicio;
import com.rustica.demo.modelo.Usuario;

@Service
public class UsuarioServicio implements UsuarioInterfaceServicio{
	
	@Autowired
	private	UsuarioInterface repo;
	
	public Usuario login(String email, String password){
		Usuario usuario=repo.findByEmailAndPassword(email, password);
		return usuario;
	}

	@Override
	public int save(Usuario u) {
		int res = 0;
		Usuario usuario=repo.save(u);
		if(!usuario.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public List<Usuario> listarusuario() {
		return (List<Usuario>)repo.findAll();
	}

	@Override
	public void delete(int idusu) {
		repo.deleteById(idusu);	
	}

	@Override
	public Usuario buscarPorId(int idusu) {
		return repo.findById(idusu).orElse(null);
	}

}
