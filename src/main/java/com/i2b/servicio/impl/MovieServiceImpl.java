package com.i2b.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2b.dominio.MovieDTO;
import com.i2b.entidad.Movie;
import com.i2b.respositorio.MovieRepository;
import com.i2b.servicio.MovieService;

@Service
public class MovieServiceImpl  implements MovieService{

	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<MovieDTO> listar() {
		return repository.findAll().stream().map(MovieServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}
	
	public static MovieDTO convertirADominio(Movie movie) {
		return new MovieDTO(movie.getId(),movie.getTitle(),movie.getDescription(),movie.getActors(),movie.getDirector(),movie.getStock());
	}
}
