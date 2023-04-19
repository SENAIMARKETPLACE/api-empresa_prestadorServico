package br.com.senai.sollaris.domain.resources.dtos.output;

import java.time.LocalDateTime;

import br.com.senai.sollaris.domain.Empresa;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ReturnEmpresaPut {
	
	private String nome_fantasia;
	private String razao_social;
	private String cnpj;
	private String telefone;
	private String email;
	private String senha;
	private LocalDateTime dt_alteracao;
	
	public ReturnEmpresaPut(Empresa empresa) {
		this.nome_fantasia = empresa.getNome_fantasia();
		this.razao_social = empresa.getRazao_social();
		this.cnpj = empresa.getCnpj();
		this.telefone = empresa.getTelefone();
		this.email = empresa.getEmail();
		this.senha = empresa.getSenha();
		this.dt_alteracao = empresa.getDt_alteracao();
	}
}
