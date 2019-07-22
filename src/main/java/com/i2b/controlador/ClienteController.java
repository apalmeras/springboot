package com.i2b.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i2b.dominio.ClienteDTO;
import com.i2b.dominio.RespuestaMensajeDTO;
import com.i2b.dominio.RespuestaUserDTO;
import com.i2b.dominio.in.UserIN;
import com.i2b.servicio.ClienteService;


@RestController
@RequestMapping("/api/v1/user")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@PostMapping
	@RequestMapping("/register")
	public RespuestaMensajeDTO registrarCliente(@RequestBody ClienteDTO clienteDTO) {
		return this.service.guardarCliente(clienteDTO);
	}
	
	
	@PostMapping
	@RequestMapping("/login")
	public RespuestaUserDTO login(@RequestBody UserIN user) {
		return this.service.login(user);
	}
}
