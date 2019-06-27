package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Conta;

@Repository //Define a classe como um bean do Spring
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta saveAndFlush(@Valid Optional<Conta> conta); } 
//Deve estender JpaRepository e declarar a entidade (Conta) e o tipo de chave primária (Long)

