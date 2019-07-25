package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produtos;
import com.example.demo.repository.ProdutosRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository produtosRepo;
	
	public Optional<Produtos> buscarPessoaPeloCodigo(Long id) {
		Optional<Produtos> produtoSalvo = produtosRepo.findById(id);
		return produtoSalvo;
	}
}
