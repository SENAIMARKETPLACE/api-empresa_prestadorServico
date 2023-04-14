package br.com.senai.sollaris.domain.resources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senai.sollaris.domain.resources.dtos.input.EnderecoDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import br.com.senai.sollaris.domain.resources.service.EnderecoService;

@RestController
@RequestMapping("api/business/address")
@CrossOrigin("http://localhost:3000")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
}
