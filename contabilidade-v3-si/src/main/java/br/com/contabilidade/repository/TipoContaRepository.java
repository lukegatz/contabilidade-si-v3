package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.TipoConta;

@Repository //Define a classe como um bean do Spring
public interface TipoContaRepository extends JpaRepository<TipoConta, Long> {

	TipoConta saveAndFlush(@Valid Optional<TipoConta> tipoConta); } 
//Deve estender JpaRepository e declarar a entidade (tipoConta) e o tipo de chave primária (Long)

