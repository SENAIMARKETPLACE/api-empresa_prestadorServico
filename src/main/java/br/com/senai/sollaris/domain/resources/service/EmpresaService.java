package br.com.senai.sollaris.domain.resources.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> listarEmpresas() {
		return empresaRepository.findAll();
	}
	
	
}
