package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Cliente;

@Repository //Define a classe como um bean do Spring
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente saveAndFlush(@Valid Optional<Cliente> cliente); } 
//Deve estender JpaRepository e declarar a entidade (Cliente) e o tipo de chave primária (Long)

