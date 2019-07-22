package com.i2b.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

	private int id;

	private String title;
	private String description;
	private String actors;
	private String director;
	private int stock;

}
