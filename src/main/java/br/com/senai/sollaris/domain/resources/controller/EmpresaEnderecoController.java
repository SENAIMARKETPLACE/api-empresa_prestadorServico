package br.com.senai.sollaris.domain.resources.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sollaris.domain.resources.dtos.input.PutEnderecoDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.service.EmpresaEnderecoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/business/address")
public class EmpresaEnderecoController {
	
	private final EmpresaEnderecoService enderecoService;
	
	@PutMapping
	public ResponseEntity<ReturnEmpresaDto> alterarEndereco(@RequestBody @Valid PutEnderecoDto enderecoDto) {
		return enderecoService.alterarEndereco(enderecoDto);
	}
}
