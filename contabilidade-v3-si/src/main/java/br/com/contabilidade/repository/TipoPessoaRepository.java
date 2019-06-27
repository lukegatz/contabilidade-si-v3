package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.TipoPessoa;

@Repository //Define a classe como um bean do Spring
public interface TipoPessoaRepository extends JpaRepository<TipoPessoa, Long> {

	TipoPessoa saveAndFlush(@Valid Optional<TipoPessoa> tipoPessoa); } 
//Deve estender JpaRepository e declarar a entidade (tipoPessoa) e o tipo de chave primária (Long)

