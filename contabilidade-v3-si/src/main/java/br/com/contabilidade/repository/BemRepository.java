package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Bem;

@Repository //Define a classe como um bean do Spring
public interface BemRepository extends JpaRepository<Bem, Long> {

	Bem saveAndFlush(@Valid Optional<Bem> bem); } 
//Deve estender JpaRepository e declarar a entidade (Bem) e o tipo de chave primária (Long)

