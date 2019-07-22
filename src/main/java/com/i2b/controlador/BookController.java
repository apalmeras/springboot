package com.i2b.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i2b.dominio.RespuestaMensajeDTO;
import com.i2b.dominio.in.BookIn;
import com.i2b.servicio.BookService;

@RestController
@RequestMapping("/api/v1/catalog/book")
public class BookController {

	@Autowired
	private BookService service;
	
	@PostMapping
	public RespuestaMensajeDTO reservar(@RequestBody BookIn book) {
		return service.reservar(book);
	}
}
