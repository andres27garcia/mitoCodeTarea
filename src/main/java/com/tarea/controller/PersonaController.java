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
import com.tarea.model.Persona;
import com.tarea.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	private IPersonaService service;

	@GetMapping
	public ResponseEntity<List<Persona>> listar() throws Exception {
		List<Persona> lista = service.listar();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Persona obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("PERSONA NO ENCONTRADA: " + id);
		}
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Persona Persona) throws Exception {
		Persona obj = service.registrar(Persona);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona Persona) throws Exception {
		Persona obj = service.modificar(Persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Persona obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("PERSONA NO ENCONTRADA: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
