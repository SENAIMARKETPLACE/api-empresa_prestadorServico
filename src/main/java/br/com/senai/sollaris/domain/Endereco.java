package br.com.senai.sollaris.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.senai.sollaris.domain.resources.dtos.input.EnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "enderecos")
public class Endereco {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Empresa empresa;
	
	private String cep;
	private String logradouro;
	private String numero;
	private String estado;
	private String bairro;
	private String cidade;
	private String complemento;
	private LocalDateTime dt_registro;
	
	public Endereco(EnderecoDto enderecoDto, Empresa empresa2) {
		 //JPA, ela pega o ID
		this.empresa = empresa2;
		
		//Campos
		this.cep = enderecoDto.getCep();
		this.logradouro = enderecoDto.getLogradouro();
		this.numero = enderecoDto.getNumero();
		this.estado = enderecoDto.getEstado();
		this.bairro = enderecoDto.getBairro();
		this.cidade = enderecoDto.getCidade();
		this.complemento = enderecoDto.getComplemento();
		this.dt_registro = LocalDateTime.now();
	}
}
