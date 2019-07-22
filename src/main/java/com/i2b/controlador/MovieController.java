package com.i2b.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i2b.dominio.MovieDTO;
import com.i2b.dominio.RespuestaMovieDTO;
import com.i2b.dominio.StatusDTO;
import com.i2b.servicio.MovieService;

@RestController
@RequestMapping("/api/v1/catalog/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	
	@GetMapping
	public RespuestaMovieDTO listar() {
		RespuestaMovieDTO respuesta = new RespuestaMovieDTO();
		List<MovieDTO> movies =service.listar();
		if(movies!=null) {
			respuesta.setStatus(new StatusDTO(200,false));
			respuesta.setMovies(movies);
		}
		return respuesta;
	}
}
