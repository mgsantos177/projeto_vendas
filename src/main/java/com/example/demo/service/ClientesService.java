package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Clientes;
import com.example.demo.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepo;
	
	public List<Clientes> listarTodos(){
		return clientesRepo.findAll();
	}	
	
	

}
