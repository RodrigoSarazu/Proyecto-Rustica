package com.rustica.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rustica.demo.modelo.Compras;

@Repository
public interface ComprasInterface extends CrudRepository<Compras,Integer>{

}
