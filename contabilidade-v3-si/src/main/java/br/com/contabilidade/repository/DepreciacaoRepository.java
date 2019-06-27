package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Depreciacao;

@Repository //Define a classe como um bean do Spring
public interface DepreciacaoRepository extends JpaRepository<Depreciacao, Long> {

	Depreciacao saveAndFlush(@Valid Optional<Depreciacao> deprec); } 
//Deve estender JpaRepository e declarar a entidade (Depreciacao) e o tipo de chave primária (Long)

