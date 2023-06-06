package br.ucsal.armazem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.armazem.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {}