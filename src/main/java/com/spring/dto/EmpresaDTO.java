package com.spring.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

public class EmpresaDTO {
	
	private Long id;
	
	@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres")
	@NotEmpty(message = "Razão social não deve ser vazia")
	private String razaoSocial;
	
	@NotEmpty(message = "CNPJ não deve ser vazio")
	@CNPJ(message = "CNPJ inválido")
	private String cnpj;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return "EmpresaDTO [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]";
	}
	
}
