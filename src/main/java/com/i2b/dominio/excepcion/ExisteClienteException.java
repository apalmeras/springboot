package com.i2b.dominio.excepcion;

public class ExisteClienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExisteClienteException(String mensaje) {
		super(mensaje);
	}
	
	public ExisteClienteException(String mensaje, Throwable throwable) {
		super(mensaje, throwable);
	}
}
