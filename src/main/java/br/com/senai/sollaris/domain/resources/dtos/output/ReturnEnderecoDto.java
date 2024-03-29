package br.com.senai.sollaris.domain.resources.dtos.output;

import br.com.senai.sollaris.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnEnderecoDto {
	private String cep;
	private String logradouro;
	private String numero;
	private String estado;
	private String bairro;
	private String cidade;
	private String complemento;
	
	//Tá sendo usado para conversão de endereço para retorno em ReturnEmpresaDto
	public ReturnEnderecoDto(Endereco endereco) {
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.estado = endereco.getEstado();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
	}
}
