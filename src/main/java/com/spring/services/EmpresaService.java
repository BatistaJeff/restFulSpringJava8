package com.spring.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entities.Empresa;
import com.spring.entities.Funcionario;
import com.spring.entities.Lancamento;
import com.spring.enums.PerfilEnum;
import com.spring.enums.TipoEnum;
import com.spring.repository.EmpresaRepository;
import com.spring.repository.FuncionarioRepository;
import com.spring.repository.LancamentoRepository;
import com.spring.utils.SenhaUtils;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private LancamentoRepository lancamentoRepository; 
	
	public void criaEmpresaUm() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("22.621.152/0001-44");
		empresa.setRazaoSocial("Teste 123");
		
		empresa = this.empresaRepository.save(empresa);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("123.123.123-01");
		funcionario.setEmail("email@email.com");
		funcionario.setEmpresa(empresa);
		funcionario.setNome("Bruce");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setQtdHorasAlmoco(1F);
		funcionario.setQtdHorasTrabalhoDia(8F);
		funcionario.setSenha(SenhaUtils.gerarBCrypt("123456"));
		funcionario.setValorHora(new BigDecimal("60"));
		
		funcionario = funcionarioRepository.save(funcionario);
		
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setDescricao("Descrição");
		lancamento.setFuncionario(funcionario);
		lancamento.setLocalizacao("Barueri");
		lancamento.setTipo(TipoEnum.INICIO_TRABALHO);
		
		lancamento = lancamentoRepository.save(lancamento);
		
		
		List<Empresa> findAll = empresaRepository.findAll();
		findAll.forEach(System.out :: println);
		
	}
	public void criaEmpresaDois() {
		Empresa empresa = new Empresa();
		empresa.setCnpj("22.621.152/0001-44");
		empresa.setRazaoSocial("Teste 123");
		
		empresa = this.empresaRepository.save(empresa);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("123.123.123-01");
		funcionario.setEmail("admin@email.com");
		funcionario.setEmpresa(empresa);
		funcionario.setNome("Thomas");
		funcionario.setPerfil(PerfilEnum.ROLE_ADMIN);
		funcionario.setQtdHorasAlmoco(1F);
		funcionario.setQtdHorasTrabalhoDia(8F);
		funcionario.setSenha(SenhaUtils.gerarBCrypt("123456"));
		funcionario.setValorHora(new BigDecimal("60"));
		
		funcionario = funcionarioRepository.save(funcionario);
		
		Lancamento lancamento = new Lancamento();
		lancamento.setData(new Date());
		lancamento.setDescricao("Descrição");
		lancamento.setFuncionario(funcionario);
		lancamento.setLocalizacao("Barueri");
		lancamento.setTipo(TipoEnum.INICIO_TRABALHO);
		
		lancamento = lancamentoRepository.save(lancamento);
		
		
		List<Empresa> findAll = empresaRepository.findAll();
		findAll.forEach(System.out :: println);
		
	}
	
	
}
