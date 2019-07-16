package com.spring.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class JwtAuthenticationDto {

	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Senha não pode ser vazio")
	private String senha;

	public JwtAuthenticationDto() {
		
	}
	
	public JwtAuthenticationDto(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
