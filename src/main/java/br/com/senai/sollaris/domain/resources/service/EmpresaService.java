package br.com.senai.sollaris.domain.resources.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.repository.EmpresaRepository;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<ReturnEmpresaDto> listarEmpresas() {
		//STREAM API - Java 8; Map ele tá varrendo a List<Empresa> (Array); ToList - transforma em lista
		return empresaRepository.findAll().stream().map(empresa -> new ReturnEmpresaDto(empresa)).toList();
	}
	
	
	public ReturnEmpresaDto listarEmpresa(Long id) {
		return empresaRepository.findById(id)
				.map(empresa -> new ReturnEmpresaDto(empresa))
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Empresa não encontrado")); 
	}
	
	public ResponseEntity<Empresa> cadastrarEmpresa(Empresa empresa, UriComponentsBuilder uriBuilder) {
		empresaRepository.save(empresa);
		URI uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();
		
		return ResponseEntity.created(uri).body(empresa);
	}
	
	@Transactional
	public ResponseEntity<Empresa> alterarEmpresa(@PathVariable Long id, Empresa empresa) {
		Optional<Empresa> empresaCaixa = empresaRepository.findById(id);
		
		if(empresaCaixa.isPresent()) {
			Empresa empresaSGBD = empresaCaixa.get();
			empresaSGBD.alterar(empresa);
			return ResponseEntity.ok(empresaSGBD);
		}
		return ResponseEntity.notFound().build();
	}
	
	@Transactional
	public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id) {
		if (empresaRepository.existsById(id)) {
			empresaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	

}
