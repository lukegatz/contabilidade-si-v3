package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Telefone;

@Repository //Define a classe como um bean do Spring
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	Telefone saveAndFlush(@Valid Optional<Telefone> fone); } 
//Deve estender JpaRepository e declarar a entidade (Telefone) e o tipo de chave primária (Long)

