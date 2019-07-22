package com.i2b.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaUserDTO extends RespuestaMensajeDTO {

	public RespuestaUserDTO(StatusDTO status, String message, ClienteDTO cliente) {
		super(status,message);
	}
}
