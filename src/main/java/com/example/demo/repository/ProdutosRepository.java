package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos,Long> {
	public Optional<Produtos> findById(Long id);

}
