package br.com.senai.sollaris.domain.resources.service;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.repository.EmpresaRepository;
import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaLogin;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaPut;
import br.com.senai.sollaris.domain.resources.service.exceptions.DadosInvalidosException;
import br.com.senai.sollaris.domain.resources.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public ResponseEntity<Page<ReturnEmpresaDto>> listarEmpresas(Pageable page) {
		//STREAM API - Java 8; Map ele tá varrendo a List<Empresa> (Array); ToList - transforma em lista
		//return empresaRepository.findAll().stream().map(empresa -> new ReturnEmpresaDto(empresa)).toList();
		
		return ResponseEntity.ok(
				empresaRepository.findAll(page)
				.map(empresa -> new ReturnEmpresaDto(empresa)));
	}
	
	
	public ResponseEntity<ReturnEmpresaDto> listarEmpresa(Long id) {
		ReturnEmpresaDto returnEmpresaDto = empresaRepository.findById(id)
				.map(empresa -> new ReturnEmpresaDto(empresa))
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Empresa não encontrada no sistema, tente novamente"));
		
		return ResponseEntity.ok(returnEmpresaDto);
	}
	
	//É utilizado pelo EnderecoService
	public Empresa buscarEmpresa(Long id) {
		return empresaRepository.findById(id)
				.orElseThrow(() -> new DadosInvalidosException("Empresa não existe no sistema, tente novamente"));
	}
	
	public ResponseEntity<ReturnEmpresaDto> cadastrarEmpresa(EmpresaDto empresaDto, UriComponentsBuilder uriBuilder) {
		
		//Nova empresa, ela tem endereço? N TEM
		Empresa empresa = new Empresa(empresaDto);
		//Salva a empresa
		empresaRepository.save(empresa);
		//Salva o endereço para a empresa, o endereço vem do DTO
		empresa.adicionarEndereco(empresaDto.getEndereco());
		
		URI uri = uriBuilder.path("/empresa/{id}").buildAndExpand(empresa.getId()).toUri();		
		return ResponseEntity.created(uri).body(new ReturnEmpresaDto(empresa));
	}
	
	@Transactional
	public ResponseEntity<ReturnEmpresaPut> alterarEmpresa(@PathVariable Long id, PutEmpresaDto empresaDto) {
		Optional<Empresa> empresaCaixa = empresaRepository.findById(id);
		
		if(empresaCaixa.isPresent()) {
			Empresa empresaSGBD = empresaCaixa.get();
			empresaSGBD.alterar(empresaDto);
			return ResponseEntity.ok(new ReturnEmpresaPut(empresaSGBD));
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
	
	@Transactional
	public ResponseEntity<ReturnEmpresaDto> logarEmpresa(EmpresaLogin empresa) {
		return ResponseEntity.ok(empresaRepository.login(empresa.getEmail(), empresa.getSenha())
				.map(ReturnEmpresaDto::new)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Email e/ou senha inválida!")));
	}
}
