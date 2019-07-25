package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Clientes;
import com.example.demo.service.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesService clientesService;
	
	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("listarClientes");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST,params = "action=listarClientes")
	public ModelAndView listarClientes() {
		return novo();
	}
	
	@ModelAttribute("addClientes")
	public List<Clientes> addCliente() {
		return clientesService.listarTodos(); 
	}
	

}
