package br.com.senai.sollaris.domain.resources.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.repository.EmpresaRepository;
import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.service.EmpresaService;

@RequestMapping("api/business")
@RestController
@CrossOrigin("http://localhost:3000") //CORS, pra reconhecer o front-end
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	//retorno
	@GetMapping
	public List<ReturnEmpresaDto> listarEmpresas () {
		return empresaService.listarEmpresas();
	}
	
	//retorno
	@GetMapping("/{id}")
	public ReturnEmpresaDto retornarEmpresa(@PathVariable Long id) {
		return empresaService.listarEmpresa(id);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Empresa> cadastrarEmpresa(@RequestBody EmpresaDto empresaDto, UriComponentsBuilder uriBuilder) {
		return empresaService.cadastrarEmpresa(empresaDto, uriBuilder);
	}
	
	@PutMapping("alterar/{id}")
	public ResponseEntity<Empresa> alterarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
		return empresaService.alterarEmpresa(id, empresa);
	}
	
	@DeleteMapping ("delete/{id}")
	public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id) {
		return empresaService.excluirEmpresa(id);
	}
	
	
	
}
