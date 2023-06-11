package br.com.senai.sollaris.domain.resources.dtos.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PutEmpresaSenhaDto {
	private Long empresa_id;
	private String senha_antiga;
	private String senha_nova;
}
