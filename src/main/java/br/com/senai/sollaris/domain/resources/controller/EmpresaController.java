package br.com.senai.sollaris.domain.resources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.resources.service.EmpresaService;

@RequestMapping("api/business")
@RestController
@CrossOrigin("http://localhost:3000")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	public List<Empresa> listarEmpresas () {
		return empresaService.listarEmpresas();
	}
	
}
