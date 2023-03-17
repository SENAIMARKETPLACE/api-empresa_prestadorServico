package br.com.senai.sollaris.domain.resources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.repository.EmpresaRepository;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.service.EmpresaService;

@RequestMapping("api/business")
@RestController
@CrossOrigin("http://localhost:3000") //CORS, pra reconhecer o front-end
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@GetMapping
	public List<ReturnEmpresaDto> listarEmpresas () {
		return empresaService.listarEmpresas();
	}
	
	@GetMapping("/{id}")
	public ReturnEmpresaDto retornarEmpresa(@PathVariable Long id) {
		return empresaService.listarEmpresa(id);
	}
	
	@DeleteMapping ("delete/{id}")
	@Transactional
	public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id) {
		return empresaService.excluirEmpresa(id);
	}
	
	
	
}
