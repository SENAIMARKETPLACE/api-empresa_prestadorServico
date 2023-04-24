package br.com.senai.sollaris.domain.resources.service.validations;

import org.springframework.stereotype.Service;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.repository.EmpresaRepository;
import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEmpresaDto;
import br.com.senai.sollaris.domain.resources.service.exceptions.CnpjEmUsoException;
import br.com.senai.sollaris.domain.resources.service.exceptions.EmailEmUsoException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpresaServiceValidation {

	private final EmpresaRepository empresaRepository;
	
	
	public void validarEmail(EmpresaDto empresa) {
		boolean email_em_uso = empresaRepository.findByEmail(empresa.getEmail())
				.stream().anyMatch(empresaSGDB -> !empresaSGDB.equals(new Empresa(empresa)));
		
		if (email_em_uso)
			throw new EmailEmUsoException("Email em uso, tente novamente!");
	}
	
	
	public void validarEmail(PutEmpresaDto empresa) {
		boolean email_em_uso = empresaRepository.findByEmail(empresa.getEmail())
				.stream().anyMatch(empresaSGDB -> !empresaSGDB.equals(new Empresa(empresa)));
		
		if (email_em_uso)
			throw new EmailEmUsoException("Email em uso, tente novamente!");
	}
	
	
	public void validarCNPJ(EmpresaDto empresaDto) {
		boolean cnpj_em_uso = empresaRepository.findByCnpj(empresaDto.getCnpj())
				.stream().anyMatch(empresaSGDB -> !empresaSGDB.equals(new Empresa(empresaDto)));
		
		if(cnpj_em_uso)
			throw new CnpjEmUsoException("CNPJ em uso, tente novamente!");
	}
}
