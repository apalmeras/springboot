package com.i2b.servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2b.dominio.ClienteDTO;
import com.i2b.dominio.RespuestaMensajeDTO;
import com.i2b.dominio.RespuestaUserDTO;
import com.i2b.dominio.StatusDTO;
import com.i2b.dominio.in.UserIN;
import com.i2b.entidad.Cliente;
import com.i2b.respositorio.ClienteRepository;
import com.i2b.servicio.ClienteService;
import com.i2b.servicio.reglas.ValidarCliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteService clienteService;

	@Override
	public ClienteDTO obtenerClienteByCedula(String cedula) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = this.clienteRepository.findById(cedula);
		if (cliente.isPresent())
			return convertirADominio(cliente.get());
		else
			return null;
	}

	@Override
	public RespuestaMensajeDTO guardarCliente(ClienteDTO clienteDTO) {
		// TODO Auto-generated ClienteDTO stub
		RespuestaMensajeDTO respuesta = null;
		if (new ValidarCliente(clienteService).verificar(clienteDTO.getId())) {
			respuesta = new RespuestaMensajeDTO(new StatusDTO(404, true), ValidarCliente.MENSAJE);
		} else {

			try {
				Cliente cliente = convertirAEntidad(clienteDTO);
				this.clienteRepository.save(cliente);
				respuesta = new RespuestaMensajeDTO(new StatusDTO(200, false), "Successfully registered user");
			} catch (Exception e) {
				respuesta = new RespuestaMensajeDTO(new StatusDTO(500, true), "Error interno del Servidor");
			}
		}

		return respuesta;
	}

	@Override
	public RespuestaUserDTO login(UserIN user) {
		RespuestaUserDTO respuesta = null;
		try {
			Optional<Cliente> cliente = this.clienteRepository.findByEmailAndPassword(user.getUser().getEmail(),
					user.getUser().getPassword());
			if (!cliente.isPresent()) {
				respuesta = new RespuestaUserDTO(new StatusDTO(404, true), "Cliente no encontrado", new ClienteDTO());
			} else {
				ClienteDTO c = convertirADominio(cliente.get());
				c.setPassword("");
				respuesta = new RespuestaUserDTO(new StatusDTO(200, false), "Logged in", c);
			}
		} catch (Exception e) {
			respuesta = new RespuestaUserDTO(new StatusDTO(500, true), "Error interno del servidor", new ClienteDTO());
		}
		return respuesta;
	}

	public static ClienteDTO convertirADominio(Cliente cliente) {
		return new ClienteDTO(cliente.getId(), cliente.getName(), cliente.getLastname(), cliente.getEmail(),
				cliente.getPhone(), cliente.getAddress(), cliente.getPassword());
	}

	public static Cliente convertirAEntidad(ClienteDTO cliente) {
		return new Cliente(cliente.getId(), cliente.getName(), cliente.getLastname(), cliente.getEmail(),
				cliente.getPhone(), cliente.getAddress(), cliente.getPassword());
	}

}
