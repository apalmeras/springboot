package com.i2b.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "costo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Costo {


	@Id
	@Column(name = "codigo")
	private String codigo;
	

	
	@Column(name = "nombre")
	private String nombre;
	
	
}
