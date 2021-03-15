package com.rustica.demo.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rustica.demo.InterfacesServicios.UserrusticaInterfaceServicio;
import com.rustica.demo.interfaces.UserrusticaInterface;
import com.rustica.demo.modelo.Userrustica;

@Service
public class UserrusticaServicio implements UserrusticaInterfaceServicio{
	@Autowired
	private UserrusticaInterface repo;
	
	public Userrustica loginadmin(String username, String password) {
		Userrustica userrustica=repo.findByUsernameAndPassword(username, password);
		return userrustica;
	}

	@Override
	public List<Userrustica> listaradmin() {
		return (List<Userrustica>)repo.findAll();
	}

	@Override
	public Optional<Userrustica> listarId(int user_id) {
		return repo.findById(user_id);
	}

	@Override
	public int save(Userrustica p) {
		int res=0;
		Userrustica userrustica=repo.save(p);
		if(!userrustica.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int user_id) {
		repo.deleteById(user_id);
	}
}
