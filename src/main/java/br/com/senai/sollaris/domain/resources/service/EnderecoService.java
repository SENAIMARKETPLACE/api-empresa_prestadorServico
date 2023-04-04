package br.com.senai.sollaris.domain.resources.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.resources.dtos.input.EnderecoDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;

@Service
public class EnderecoService {
	
	@Autowired
	private EmpresaService empresaService;
	
	@Transactional //POST, PUT e Delete, TCL
	public ResponseEntity<ReturnEmpresaDto> cadastrarEndereco(EnderecoDto endereco, UriComponentsBuilder uriBuilder) {
		//Reflexo, é necessário buscar uma empresa
		Empresa empresa = empresaService.buscarEmpresa(endereco.getEmpresa_id());
		empresa.adicionarEndereco(empresa, endereco);
		
		URI uri = uriBuilder.path("api/business/address/{id}").buildAndExpand(empresa.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReturnEmpresaDto(empresa));
		
	}

}
