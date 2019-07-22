package com.i2b.respositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.i2b.entidad.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>, JpaSpecificationExecutor<Cliente> {

	public Optional<Cliente> findById(String cedula);
	
	public Optional<Cliente> findByEmailAndPassword(String email, String password);
}
