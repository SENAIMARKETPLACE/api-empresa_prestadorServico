package br.com.senai.sollaris.domain.resources.handleExceptions;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.senai.sollaris.domain.resources.service.exceptions.DadosInvalidosException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class RespostaException {
	private String titulo;
	private StringBuffer Url;
	private Integer status;
	private String recurso;
	private LocalDateTime dataRequisicao;
	private List<Campo> campos;
	
	public RespostaException(HttpStatus status, List<Campo> campos) {
		this.titulo = "Campos inválidos, tente novamente";
		this.status = status.value();
		this.dataRequisicao = LocalDateTime.now();
		this.campos = campos;
	}

	public RespostaException(String titulo, int status, HttpServletRequest request) {
		this.titulo = titulo;
		this.status = status;
		this.recurso = request.getRequestURI();
		this.Url = request.getRequestURL();
		this.dataRequisicao = LocalDateTime.now();
	}
	
	public RespostaException(DadosInvalidosException ex, HttpStatus status, HttpServletRequest request) {
		this.titulo = ex.getMessage();
		this.status = status.value();
		this.recurso = request.getRequestURI();
		this.Url = request.getRequestURL();
		this.dataRequisicao = LocalDateTime.now();
	}



}
