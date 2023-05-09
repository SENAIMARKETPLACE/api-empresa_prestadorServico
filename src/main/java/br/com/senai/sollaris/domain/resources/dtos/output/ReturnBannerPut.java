package br.com.senai.sollaris.domain.resources.dtos.output;

import br.com.senai.sollaris.domain.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnBannerPut {
	
	private Long id;
	private String url_banner;
	
	public ReturnBannerPut (Empresa empresa){
		this.id = empresa.getId();
		this.url_banner = empresa.getBanner();
	}
}
