package com.example.demo.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vendas;
import com.example.demo.repository.VendasRepository;

@Service
public class VendasService {
	
	private DecimalFormat df = new DecimalFormat();
	
	public VendasService() {
		df.setMinimumFractionDigits(2);
		df.setMaximumIntegerDigits(2);
	
	}
	
	@Autowired
	private VendasRepository vendasRepository;
	
	public List<Vendas> listarTodos(){
		return vendasRepository.findAll();
	}	
	
	public Vendas salvar(Vendas vendas) {
		return vendasRepository.save(vendas);
	}
	
	public File exportarVendas() throws IOException {
		List<Vendas> findAll = listarTodos();
		File arquivo = new File("temp.csv");
		FileWriter fw = new FileWriter(arquivo);
		fw.append("id_cliente;nome_cliente;id_produto;descricao_produto;quantidade;valor_total\r\n");
		for (Vendas venda : findAll) {
			fw.append(venda.getClientes().getId().toString().concat(";"));
			fw.append(venda.getClientes().getNome().concat(";"));
			fw.append(venda.getProdutos().getId().toString().concat(";"));
			fw.append(venda.getProdutos().getNome().concat(";"));
			fw.append(Integer.toString(venda.getQuantProdutos()).concat(";"));
			fw.append(Float.toString(venda.getValorTotal()).concat(";\r\n"));
		}
		fw.flush();
		fw.close();

		
		return arquivo;
	}


}
