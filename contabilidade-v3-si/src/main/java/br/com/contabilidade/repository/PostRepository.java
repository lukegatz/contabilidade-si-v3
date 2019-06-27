package br.com.contabilidade.repository;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contabilidade.model.Post;

@Repository //Define a classe como um bean do Spring
public interface PostRepository extends JpaRepository<Post, Long> {

	Post saveAndFlush(@Valid Optional<Post> post); } 
//Deve estender JpaRepository e declarar a entidade (Post) e o tipo de chave primária (Long)

