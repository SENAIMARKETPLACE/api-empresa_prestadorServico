package br.com.senai.sollaris.domain.resources.dtos.input;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDto {

	@NotBlank
	private String nome_fantasia;
	@NotBlank
	private String razao_social;
	@NotBlank
	@CNPJ
	private String cnpj;
	@NotBlank
	private String telefone;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String senha;
	
}
