package br.com.senai.sollaris.domain.resources.dtos.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Data
public class EmpresaLogin {

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String senha;
	
}
