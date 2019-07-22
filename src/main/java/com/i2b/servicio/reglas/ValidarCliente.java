package com.i2b.servicio.reglas;

import com.i2b.dominio.ClienteDTO;
import com.i2b.servicio.ClienteService;

public class ValidarCliente {

	public static final String MENSAJE = "Cliente ya existe";

	
	private ClienteService clienteService;
	
	public ValidarCliente(ClienteService clienteService) {
		this.clienteService=clienteService;
	}
	
	public boolean verificar(String cedula) {
		ClienteDTO cliente = clienteService.obtenerClienteByCedula(cedula);
		return cliente!=null;
	}

}
