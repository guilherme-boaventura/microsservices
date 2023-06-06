package br.ucsal.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.loja.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
