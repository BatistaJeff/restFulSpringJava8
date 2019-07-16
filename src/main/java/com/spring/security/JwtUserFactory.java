package com.spring.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.spring.entities.Funcionario;
import com.spring.enums.PerfilEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {

	}

	/**
	 * Converte e gera um JwtUser com base nos dados de um funcionario
	 * @param funcionario
	 * @return {@link JwtUser}
	 */
	public static JwtUser create(Funcionario funcionario) {
		return new JwtUser(funcionario.getId()
						 , funcionario.getEmail()
						 , funcionario.getSenha()
						 , mapToGrantedAuthorities(funcionario.getPerfil()));
	}

	/**
	 * Converte o perfil do usuário para o formato utilizado pelo Spring Security 
	 * @param perfil
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfil) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfil.toString()));
		return authorities;
	}

}
