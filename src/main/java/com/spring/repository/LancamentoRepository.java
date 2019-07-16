package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
