
package br.com.senai.sollaris.domain.resources.dtos.input;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutEmpresaDto {

	private String nome_proprietario;
	private String nome_fantasia;
	private String razao_social;
	@CNPJ
	private String cnpj;
	private String telefone;
	@Email
	private String email;
	private String senha;
	private String url_logo;

}
