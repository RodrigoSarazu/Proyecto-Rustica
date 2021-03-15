package com.rustica.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rustica.demo.modelo.Orden_Pago;

@Repository
public interface Orden_PagoInterfaces extends CrudRepository<Orden_Pago, Integer>{

}
