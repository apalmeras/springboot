package com.i2b.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Movie {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description" , length= 1000)
	private String description;
	
	@Column(name = "actors")
	private String actors;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "stock")
	private int stock;
}
