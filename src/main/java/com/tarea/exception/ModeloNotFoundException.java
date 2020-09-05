package com.tarea.exception;

public class ModeloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 236583443449900467L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
