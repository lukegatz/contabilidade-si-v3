package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.TipoBem;

@Repository //Define a classe como um bean do Spring
public interface TipoBemRepository extends JpaRepository<TipoBem, Long> {

	TipoBem saveAndFlush(@Valid Optional<TipoBem> tipoBem); } 
//Deve estender JpaRepository e declarar a entidade (tipoBem) e o tipo de chave primária (Long)

