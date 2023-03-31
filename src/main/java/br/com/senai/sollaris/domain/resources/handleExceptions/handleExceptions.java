package br.com.senai.sollaris.domain.resources.handleExceptions;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.senai.sollaris.domain.resources.service.exceptions.DadosInvalidosException;
import br.com.senai.sollaris.domain.resources.service.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class handleExceptions extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Campo> listaDeErros = new ArrayList<>();
		List<FieldError> todosOsErros = ex.getBindingResult().getFieldErrors();
		
		todosOsErros.forEach(error -> {
			String nome = error.getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			listaDeErros.add(new Campo(nome, mensagem));
		});
		
		RespostaException respostaException = new RespostaException(status, listaDeErros);
		
		return handleExceptionInternal(ex, respostaException, headers, status, request);
	}
	
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<RespostaException> ObjetoNaoEncontrado(ObjetoNaoEncontradoException ex, 
			HttpServletRequest request2) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		RespostaException respostaException = new RespostaException(ex.getMessage(), status.value(), request2);
		
		return ResponseEntity.status(status).body(respostaException);
		
	}
	
	@ExceptionHandler(DadosInvalidosException.class)
	public ResponseEntity<Object> DadosInvalidosException(DadosInvalidosException ex, 
			HttpServletRequest request2) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		RespostaException respostaException = new RespostaException(ex.getMessage(), status.value(), request2);
		
		return ResponseEntity.status(status).body(respostaException);
	}
}
