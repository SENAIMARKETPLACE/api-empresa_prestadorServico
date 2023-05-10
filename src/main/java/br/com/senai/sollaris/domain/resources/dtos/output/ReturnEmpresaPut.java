package br.com.senai.sollaris.domain.resources.dtos.output;

import br.com.senai.sollaris.domain.Empresa;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ReturnEmpresaPut {
	
	private Long id;
	private String nome_proprietario;
	private String nome_fantasia;
	private String razao_social;
	private String cnpj;
	private String telefone;
	private String email;
	private String senha;
	private String url_logo;
	
	public ReturnEmpresaPut(Empresa empresa) {
		this.id = empresa.getId();
		this.nome_fantasia = empresa.getNome_fantasia();
		this.razao_social = empresa.getRazao_social();
		this.cnpj = empresa.getCnpj();
		this.nome_proprietario = empresa.getNome_responsavel();
		this.telefone = empresa.getTelefone();
		this.email = empresa.getEmail();
		this.senha = empresa.getSenha();
		this.url_logo = empresa.getImg();
	}
}
