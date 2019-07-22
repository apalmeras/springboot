package com.i2b.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i2b.entidad.Costo;
import com.i2b.servicio.CostoService;

@RestController
@RequestMapping("/costo")
public class CostoController {

	@Autowired
	private CostoService service;
	
	@RequestMapping("/lista")
	@GetMapping
	public List<CostoDTO> listar(){
		return this.service.listar();
	}
}
