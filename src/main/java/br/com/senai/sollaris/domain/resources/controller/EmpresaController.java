package br.com.senai.sollaris.domain.resources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaLogin;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaPut;
import br.com.senai.sollaris.domain.resources.service.EmpresaService;

@RequestMapping("api/business")
@RestController
@CrossOrigin("http://localhost:3000") //CORS, pra reconhecer o front-end
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	/*
	 * Size = Define a quantidade de páginas
	 * page = A pagina que você vai consultar
	 */
	@GetMapping
	public ResponseEntity<Page<ReturnEmpresaDto>> listarEmpresas (
			@PageableDefault(size = 5) Pageable page) {
		return empresaService.listarEmpresas(page);
	}
	
	//retorno
	@GetMapping("/{id}")
	public ResponseEntity<ReturnEmpresaDto> retornarEmpresa(@PathVariable Long id) {
		return empresaService.listarEmpresa(id);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ReturnEmpresaDto> cadastrarEmpresa(@RequestBody EmpresaDto empresaDto, UriComponentsBuilder uriBuilder) {
		return empresaService.cadastrarEmpresa(empresaDto, uriBuilder);
	}
	
	@PutMapping("alterar/{id}")
	public ResponseEntity<ReturnEmpresaPut> alterarEmpresa(@PathVariable Long id, @RequestBody PutEmpresaDto empresaDto) {
		return empresaService.alterarEmpresa(id, empresaDto);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id) {
		return empresaService.excluirEmpresa(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ReturnEmpresaDto> logarEmpresa(EmpresaLogin empresa) {
		return empresaService.logarEmpresa(empresa);
	}
	
}
