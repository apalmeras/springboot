package com.i2b.dominio;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CcostoDTO {

	private String codigo;
	private String descripcion;
	private Date fecha;
}
