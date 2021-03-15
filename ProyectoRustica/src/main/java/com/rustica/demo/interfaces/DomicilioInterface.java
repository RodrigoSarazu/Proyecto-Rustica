package com.rustica.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rustica.demo.modelo.Domicilio;

@Repository
public interface DomicilioInterface extends CrudRepository<Domicilio, Integer> {
}
