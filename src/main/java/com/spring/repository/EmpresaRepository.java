package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	Empresa findByCnpj(String cnpj);
	
}
