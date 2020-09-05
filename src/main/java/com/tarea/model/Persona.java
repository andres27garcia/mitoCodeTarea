package com.tarea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;

	@NotNull(message = "{persona.nombres.notNull}")
	@Size(min = 1, max = 15, message = "{persona.nombres.size}")
	@Column(name = "nombres", nullable = false, length = 15)
	private String nombres;

	@NotNull(message = "{persona.apellidos.notNull}")
	@Size(min = 3, max = 15, message = "{persona.apellidos.size}")
	@Column(name = "apellidos", nullable = false, length = 15)
	private String apellidos;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
