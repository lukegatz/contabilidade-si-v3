package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Lancamento;

@Repository //Define a classe como um bean do Spring
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	Lancamento saveAndFlush(@Valid Optional<Lancamento> lancamento); } 
//Deve estender JpaRepository e declarar a entidade (Lancamento) e o tipo de chave primária (Long)

