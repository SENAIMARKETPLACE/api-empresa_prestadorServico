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

import br.com.senai.sollaris.domain.resources.dtos.input.EmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.input.EnderecoDto;
import br.com.senai.sollaris.domain.resources.dtos.input.PutBannerDto;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEmpresaDto;
import br.com.senai.sollaris.domain.resources.dtos.input.PutEmpresaDto2;
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
	private Long id;
	private String nome_fantasia;
	private String razao_social;
	private String cnpj;
	
	private String nome_responsavel;
	private String telefone;
	private String email;
	private String senha;
	private String img;
	private String banner;
	private LocalDateTime dt_registro;
	private LocalDateTime dt_alteracao;
	
	@OneToMany (mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	//Utilizado para Put de banner
	public void alterarBanner(PutBannerDto bannerDto) {
		this.banner = bannerDto.getUrl_banner();
		this.dt_alteracao = LocalDateTime.now();
	}
	
	//Utilizado para Put de emdpresa
	public void alterar(PutEmpresaDto empresaDto) {
		
		if (empresaDto.getNome_fantasia() != null) {
			this.nome_fantasia = empresaDto.getNome_fantasia();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getCnpj() != null) {
			this.cnpj = empresaDto.getCnpj();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getNome_proprietario() != null) {
			this.nome_responsavel = empresaDto.getNome_proprietario();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getEmail() != null) {
			this.email = empresaDto.getEmail();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getSenha() != null) {
			this.senha = empresaDto.getSenha();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getRazao_social() != null) {
			this.razao_social = empresaDto.getRazao_social();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getTelefone() != null) {
			this.telefone = empresaDto.getTelefone();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getUrl_logo() != null) {
			this.img = empresaDto.getUrl_logo();
			this.dt_alteracao = LocalDateTime.now();
		}		
	}
	
	//Utilizado para cadastrar Produto
	public Empresa(EmpresaDto empresaDto) {
		this.nome_fantasia = empresaDto.getNome_fantasia();
		this.razao_social = empresaDto.getRazao_social();
		this.cnpj = empresaDto.getCnpj();
		this.nome_responsavel = empresaDto.getNome_proprietario();
		this.telefone = empresaDto.getTelefone();
		this.email = empresaDto.getEmail();
		this.senha = empresaDto.getSenha();
		this.img = empresaDto.getUrl_logo();
		this.dt_registro = LocalDateTime.now();
	}
	
	public void adicionarEndereco(EnderecoDto endereco) {
		this.enderecos.add(new Endereco(endereco, this));
		
	}
	
	//Utilizado no EmpresaServiceValidation
	public Empresa(PutEmpresaDto empresaDto) {
		this.nome_fantasia = empresaDto.getNome_fantasia();
		this.razao_social = empresaDto.getRazao_social();
		this.cnpj = empresaDto.getCnpj();
		this.nome_responsavel = empresaDto.getNome_proprietario();
		this.telefone = empresaDto.getTelefone();
		this.email = empresaDto.getEmail();
		this.senha = empresaDto.getSenha();
		this.img = empresaDto.getUrl_logo();
		
	}

	public void alterar(PutEmpresaDto2 empresaDto) {
		if (empresaDto.getEmail() != null) {
			this.email = empresaDto.getEmail();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getRazao_social() != null) {
			this.razao_social = empresaDto.getRazao_social();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getTelefone() != null) {
			this.telefone = empresaDto.getTelefone();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getUrl_logo() != null) {
			this.img = empresaDto.getUrl_logo();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getNome_fantasia() != null) {
			this.nome_fantasia = empresaDto.getNome_fantasia();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getCnpj() != null) {
			this.cnpj = empresaDto.getCnpj();
			this.dt_alteracao = LocalDateTime.now();
		}
		
		if (empresaDto.getUrl_banner() != null) {
			this.banner = empresaDto.getUrl_banner();
			this.dt_alteracao = LocalDateTime.now();
		}	
	}
}
