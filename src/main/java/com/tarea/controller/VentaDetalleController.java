package com.tarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tarea.exception.ModeloNotFoundException;
import com.tarea.model.DetalleVenta;
import com.tarea.service.IDetalleVentaService;

@RestController
@RequestMapping("/detalleventas")
public class VentaDetalleController {

	private IDetalleVentaService service;

	@GetMapping
	public ResponseEntity<List<DetalleVenta>> listar() throws Exception {
		List<DetalleVenta> lista = service.listar();
		return new ResponseEntity<List<DetalleVenta>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalleVenta> listarPorId(@PathVariable("id") Integer id) throws Exception {
		DetalleVenta obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("DETALLE NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<DetalleVenta>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody DetalleVenta detalle) throws Exception {
		DetalleVenta obj = service.registrar(detalle);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdDetalleVenta()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<DetalleVenta> modificar(@Valid @RequestBody DetalleVenta detalle) throws Exception {
		DetalleVenta obj = service.modificar(detalle);
		return new ResponseEntity<DetalleVenta>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		DetalleVenta obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("DETALLE NO ENCONTRADO: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
