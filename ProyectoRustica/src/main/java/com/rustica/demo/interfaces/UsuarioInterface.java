package com.rustica.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;     
import org.springframework.stereotype.Repository;

import com.rustica.demo.modelo.Usuario;

@Repository
public interface UsuarioInterface extends JpaRepository<Usuario, Integer>{
	Usuario findByEmailAndPassword(String email, String password);
	Usuario findByEmail(String email);
}
