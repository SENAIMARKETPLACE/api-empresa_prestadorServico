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
	private String nome_proprietario;
	private String nome_fantasia;
	private String cnpj;
	private String nome_responsavel;
	private String telefone;
	private String url_logo;
	private List<ReturnEnderecoDto> enderecos;
	
	public ReturnEmpresaDto(Empresa empresa) {
		this.id = empresa.getId();
		this.nome_proprietario = empresa.getNome_responsavel();
		this.nome_fantasia = empresa.getNome_fantasia();
		this.cnpj = empresa.getCnpj();
		this.telefone = empresa.getTelefone();
		this.url_logo = empresa.getImg();
		this.enderecos = empresa.getEnderecos()
				.stream().map(endereco -> new ReturnEnderecoDto(endereco)).toList();
	}
}
