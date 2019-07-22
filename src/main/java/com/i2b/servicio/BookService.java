package com.i2b.servicio;

import com.i2b.dominio.RespuestaMensajeDTO;
import com.i2b.dominio.in.BookIn;

public interface BookService {

	public RespuestaMensajeDTO reservar(BookIn book);
}
