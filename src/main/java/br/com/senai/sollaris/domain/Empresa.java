package br.com.senai.sollaris.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.input.EnderecoDto;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEmpresaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String nome_fantasia;
	private String razao_social;
	private String cnpj;
	
	private String telefone;
	private String email;
	private String senha;
	private LocalDateTime dt_registro;
	private LocalDateTime dt_alteracao;
	
	@OneToMany (mappedBy = "empresa", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Endereco> enderecos = new ArrayList<>();
	
	//Utilizado para Put de emdpresa
	public void alterar(PutEmpresaDto empresaDto) {
		this.nome_fantasia = empresaDto.getNome_fantasia();
		this.razao_social = empresaDto.getRazao_social();
		this.cnpj = empresaDto.getCnpj();
		this.telefone = empresaDto.getTelefone();
		this.email = empresaDto.getEmail();
		this.senha = empresaDto.getSenha();
		this.dt_alteracao = LocalDateTime.now();
	}

	public Empresa(EmpresaDto empresaDto) {
		this.nome_fantasia = empresaDto.getNome_fantasia();
		this.razao_social = empresaDto.getRazao_social();
		this.cnpj = empresaDto.getCnpj();
		this.telefone = empresaDto.getTelefone();
		this.email = empresaDto.getEmail();
		this.senha = empresaDto.getSenha();
		this.dt_registro = LocalDateTime.now();
	}
	
	public Empresa(PutEmpresaDto putEmpresaDto) {
		this.nome_fantasia = putEmpresaDto.getNome_fantasia();
		this.razao_social = putEmpresaDto.getRazao_social();
		this.cnpj = putEmpresaDto.getCnpj();
		this.telefone = putEmpresaDto.getTelefone();
		this.email = putEmpresaDto.getEmail();
		this.senha = putEmpresaDto.getSenha();
		
	}

	public void adicionarEndereco(EnderecoDto endereco) {
		this.enderecos.add(new Endereco(endereco, this));
		
	}


}
