package br.com.senai.sollaris.domain.resources.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PutEnderecoDto {
	
	@NotNull
	private Long empresa_id;
	
	@NotNull
	private Long endereco_id;
	
	@NotBlank
	private String cep;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;
	@NotBlank
	private String estado;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	
	private String complemento;
}
