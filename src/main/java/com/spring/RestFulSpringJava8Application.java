package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.services.EmpresaService;
import com.spring.utils.SenhaUtils;

@SpringBootApplication
public class RestFulSpringJava8Application {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private EmpresaService empresaServices;
	
	public static void main(String[] args) {
		SpringApplication.run(RestFulSpringJava8Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			//properties
			System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);
			//Senha
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
			System.out.println("### Senha encoded: " + senhaEncoded);
			System.out.println("### Senha Válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));

			//Testar JPADATA
			empresaServices.criaEmpresaUm();
			
			//Testar JPADATA
			empresaServices.criaEmpresaDois();
			

		};
	}

	

}
