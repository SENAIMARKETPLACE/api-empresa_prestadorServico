package br.com.senai.sollaris.domain.resources.dtos.output;

import java.util.List;

import br.com.senai.sollaris.domain.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class ReturnEmpresaDto {
	
	private Long id;
	private String nome_fantasia;
	private String cnpj;
	private String telefone;
	private List<ReturnEnderecoDto> enderecos;
	
	public ReturnEmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.nome_fantasia = empresa.getNome_fantasia();
		this.cnpj = empresa.getCnpj();
		this.telefone = empresa.getTelefone();
		this.enderecos = empresa.getEnderecos()
				.stream().map(endereco -> new ReturnEnderecoDto(endereco)).toList();
	}
}
