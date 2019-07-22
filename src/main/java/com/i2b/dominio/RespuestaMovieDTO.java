package com.i2b.dominio;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaMovieDTO {

	private StatusDTO status;
	private List<MovieDTO> movies;
	
}
