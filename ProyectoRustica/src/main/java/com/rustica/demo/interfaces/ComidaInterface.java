package com.rustica.demo.interfaces;

import org.springframework.data.repository.CrudRepository;  

import com.rustica.demo.modelo.Comida;  

public interface ComidaInterface extends CrudRepository<Comida, Integer>{
	Comida findFirstByNombre(String nombre);
}
