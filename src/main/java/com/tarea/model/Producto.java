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
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	
	@NotNull(message = "{producto.nombre.notNull}")
	@Size(min = 3, max = 50, message = "{producto.nombre.size}")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@NotNull(message = "{producto.marca.notNull}")
	@Size(min = 3, max = 30, message = "{producto.marca.size}")
	@Column(name = "marca", nullable = false, length = 30)
	private String marca;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
