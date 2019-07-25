//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.demo.model.Produtos;
//import com.example.demo.service.ProdutosService;
//
//@Controller
//@RequestMapping("/produtos")
//public class ProdutosController {
//	
//	@Autowired
//	private ProdutosService produtosService;
//	
//	@RequestMapping
//	public ModelAndView novo() {
//		ModelAndView mv = new ModelAndView("listarProdutos");
//		return mv;
//	}
//	
//	@ModelAttribute("addProduto")
//	public List<Produtos> addProduto() {
//		return produtosService.listarTodos();
//	}
//
//}