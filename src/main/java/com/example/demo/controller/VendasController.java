package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Clientes;
import com.example.demo.model.Produtos;
import com.example.demo.model.Vendas;
import com.example.demo.repository.ProdutosRepository;
import com.example.demo.service.ClientesService;
import com.example.demo.service.VendasService;

@Controller
@RequestMapping("/vendas")
public class VendasController {
	
	@Autowired
	private ClientesService clientesService;
	@Autowired
	private VendasService vendasService;
	@Autowired
	private ProdutosRepository produtosRepo;

	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastrarVenda");
		mv.addObject("vendas", new Vendas());
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView sucess() {
		ModelAndView mv = new ModelAndView("cadastrarVenda");
		mv.addObject("vendas", new Vendas());
		mv.addObject("mensagem","Compra realizada com sucesso!");
		return mv;
	}
	
	
	@RequestMapping(method = RequestMethod.POST,params = "action=limpar")
	public ModelAndView limpar() {
	return novo();
	}
	
	@RequestMapping(method = RequestMethod.POST,params = "action=cadastrar")
	public ModelAndView salvar(Vendas vendas) {
		calcularTotal(vendas);
		vendasService.salvar(vendas);
		return sucess();
	}
	
	@RequestMapping(method = RequestMethod.POST,params = "action=calcular")
	public ModelAndView calcular(Vendas vendas) {
		calcularTotal(vendas);
		ModelAndView mv = new ModelAndView("cadastrarVenda");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,params = "action=listarClientes")
	public ModelAndView listarClientes(Vendas vendas) {
		ModelAndView mv = new ModelAndView("listarClientes");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,params = "action=listarProdutos")
	public ModelAndView listarProdutos(Vendas vendas) {
		ModelAndView mv = new ModelAndView("listarProdutos");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,params = "action=listarVendas")
	public ModelAndView listarVendas(Vendas vendas) {
		ModelAndView mv = new ModelAndView("listarVendas");
		return mv;
	}
	
	
	
	

	private void calcularTotal(Vendas vendas) {
		Produtos produtos = vendas.getProdutos();
		int quantProdutos = vendas.getQuantProdutos();
		vendas.setValorTotal(produtos.getValor()*quantProdutos);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, params = "action=exportar")
    public ResponseEntity<?> exportarTxt(Vendas vendas) throws IOException  {
    	
    	File arquivo = vendasService.exportarVendas();
       
    	InputStreamResource resource = new InputStreamResource(new FileInputStream(arquivo));
    	
    	arquivo.delete();
        return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=\"relatorio_vendas.csv\"").contentLength(arquivo.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

	@ModelAttribute("addVenda")
	public List<Vendas> addVenda() {
		return vendasService.listarTodos(); 
	}
	
	
	@ModelAttribute("addCliente")
	public List<Clientes> addCliente() {
		return clientesService.listarTodos(); 
	}
	
	@ModelAttribute("addProduto")
	public List<Produtos> addProduto() {
		return produtosRepo.findAll();
	}
	
}