package com.rustica.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rustica.demo.modelo.Userrustica;

@Repository
public interface UserrusticaInterface extends JpaRepository<Userrustica, Integer>{
	Userrustica findByUsernameAndPassword(String username, String password);
}
