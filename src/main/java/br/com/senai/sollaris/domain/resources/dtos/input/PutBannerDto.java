package br.com.senai.sollaris.domain.resources.dtos.input;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutBannerDto {
	
	@NotBlank
	private String url_banner;
}
