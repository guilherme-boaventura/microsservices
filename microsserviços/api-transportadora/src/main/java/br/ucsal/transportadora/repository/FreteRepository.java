package br.ucsal.transportadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.transportadora.model.Frete;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

}
