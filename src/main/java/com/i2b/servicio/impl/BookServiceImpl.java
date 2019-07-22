package com.i2b.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2b.dominio.RespuestaMensajeDTO;
import com.i2b.dominio.StatusDTO;
import com.i2b.dominio.in.BookIn;
import com.i2b.entidad.Book;
import com.i2b.respositorio.BookRepository;
import com.i2b.respositorio.ClienteRepository;
import com.i2b.respositorio.MovieRepository;
import com.i2b.servicio.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository repository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	public RespuestaMensajeDTO reservar(BookIn book) {
		RespuestaMensajeDTO respuesta = null;
		try {
			if((this.movieRepository.findById(book.getBook().getMovieId()).isPresent())&&(this.clienteRepository.findById(book.getBook().getUserId())).isPresent()) {
				this.repository.save(new Book(book.getBook().getUserId(),book.getBook().getMovieId()));
				respuesta = new RespuestaMensajeDTO(new StatusDTO(200,false),"Successful booking");
			}else {
				respuesta = new RespuestaMensajeDTO(new StatusDTO(404,true),"Error al realizar la reserva");
			}
		}catch(Exception e) {
			respuesta = new RespuestaMensajeDTO(new StatusDTO(500,true),"Error interno del servidor"+ e.getMessage());
			
		}
		return respuesta;
	}

}
