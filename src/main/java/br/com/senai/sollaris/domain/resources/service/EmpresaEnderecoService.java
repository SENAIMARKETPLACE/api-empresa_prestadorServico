package br.com.senai.sollaris.domain.resources.service;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senai.sollaris.domain.Empresa;
import br.com.senai.sollaris.domain.Endereco;
import br.com.senai.sollaris.domain.repository.EnderecoRepository;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEnderecoDto;
import br.com.senai.sollaris.domain.resources.dtos.output.ReturnEmpresaDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpresaEnderecoService {

	private final EmpresaService empresaService;
	private final EnderecoRepository enderecoRepository;
	
	@Transactional
	public ResponseEntity<ReturnEmpresaDto> alterarEndereco(PutEnderecoDto enderecoDto) {
		Empresa buscarEmpresa = empresaService.buscarEmpresa(enderecoDto.getEmpresa_id());
		boolean isAlterado = false;
		
		for (Endereco endereco : buscarEmpresa.getEnderecos()) {
			if (endereco.getId() == enderecoDto.getEndereco_id()) {
				endereco.alterar(enderecoDto);
				enderecoRepository.save(endereco);
				isAlterado = true;
				break;
			}
		}
		
		
		if (isAlterado)
			return ResponseEntity.ok(new ReturnEmpresaDto(buscarEmpresa));
		
		return ResponseEntity.notFound().build();
	}

}
