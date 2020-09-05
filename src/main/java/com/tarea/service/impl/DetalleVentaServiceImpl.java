package com.tarea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.DetalleVenta;
import com.tarea.repo.IDetalleVentaRepo;
import com.tarea.repo.IGenericRepo;
import com.tarea.service.IDetalleVentaService;

@Service
public class DetalleVentaServiceImpl extends CRUDImpl<DetalleVenta, Integer> implements IDetalleVentaService{

	@Autowired
	private IDetalleVentaRepo repo;
	
	@Override
	protected IGenericRepo<DetalleVenta, Integer> getRepo(){
		return repo;
	}

}
