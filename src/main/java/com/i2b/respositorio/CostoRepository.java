package com.i2b.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.i2b.entidad.Costo;

public interface CostoRepository extends JpaRepository<Costo, String>, JpaSpecificationExecutor<Costo> {

}
