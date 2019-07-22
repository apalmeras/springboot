package com.i2b.servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i2b.controlador.CostoDTO;
import com.i2b.entidad.Costo;
import com.i2b.respositorio.CostoRepository;
import com.i2b.servicio.CostoService;

@Service
public class CostoServiceImpl implements CostoService {

	@Autowired 
	private CostoRepository costoRepository;
	
	@Override
	public List<CostoDTO> listar() {
		// TODO Auto-generated method stub
		return this.costoRepository.findAll().stream().map(CostoServiceImpl::convertirADominio)
				.collect(Collectors.toList());
	}
	
	public static CostoDTO convertirADominio(Costo costo) {
		return new CostoDTO(costo.getCodigo(),costo.getNombre());
	}

	
}
