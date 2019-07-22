package com.i2b.controlador;

import java.util.Calendar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.i2b.dominio.RespuestaErrorDTO;
import com.i2b.dominio.excepcion.RegistroNoExisteException;

@ControllerAdvice
public class ControlErrorHandler {

	@ExceptionHandler(RegistroNoExisteException.class)
	public ResponseEntity<RespuestaErrorDTO> handleException(RegistroNoExisteException ex, WebRequest request) {
		RespuestaErrorDTO excepcion = new RespuestaErrorDTO(Calendar.getInstance().getTime(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaErrorDTO> handleException(Exception ex, WebRequest request) {
		RespuestaErrorDTO excepcion = new RespuestaErrorDTO(Calendar.getInstance().getTime(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(excepcion, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<RespuestaErrorDTO> handleException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
		RespuestaErrorDTO excepcion = new RespuestaErrorDTO(Calendar.getInstance().getTime(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(excepcion, HttpStatus.NOT_FOUND);
	}
}
