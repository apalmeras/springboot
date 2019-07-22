package com.i2b.servicio;

import com.i2b.dominio.ClienteDTO;
import com.i2b.dominio.RespuestaMensajeDTO;
import com.i2b.dominio.RespuestaUserDTO;
import com.i2b.dominio.in.UserIN;;

public interface ClienteService {

	public ClienteDTO obtenerClienteByCedula(String cedula);
	
	public RespuestaMensajeDTO guardarCliente(ClienteDTO cliente);
	
	public RespuestaUserDTO login(UserIN user);
}
