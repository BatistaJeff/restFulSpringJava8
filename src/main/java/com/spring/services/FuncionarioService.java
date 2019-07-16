package com.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entities.Funcionario;
import com.spring.repository.FuncionarioRepository;
import com.spring.services.interfaces.IFuncionarioService;

@Service
public class FuncionarioService implements IFuncionarioService{

	@Autowired
	private FuncionarioRepository funcionarioRepository; 
	
	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		return Optional.ofNullable(this.funcionarioRepository.findByEmail(email));
	}

	
	
}
