package br.ucsal.transportadora.model;

import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Frete")
public class Frete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer numVeiculos;
	
	@ElementCollection
	private Map<Long, Integer> itens;


	public Frete() {
		super();
	}
	
	public Frete(Map<Long, Integer> itens,Integer numVeiculos) {
		this();
		this.setItens(itens);
		this.setnumVeiculos(numVeiculos);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getnumVeiculos() {
		return numVeiculos;
	}

	public void setnumVeiculos(Integer numVeiculos) {
		this.numVeiculos = numVeiculos;
	}

	public Map<Long, Integer> getItens() {
		return itens;
	}

	public void setItens(Map<Long, Integer> itens) {
		this.itens = itens;
	}
}