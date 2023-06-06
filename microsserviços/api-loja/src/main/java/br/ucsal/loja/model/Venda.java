package br.ucsal.loja.model;

import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection
	private Map<Long, Integer> produtos;
	
	public Venda() {
		super();
	}
	
	public Venda(Map<Long, Integer> produtos) {
		this();
		this.setProdutos(produtos);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Long, Integer> getProdutos() {
		return produtos;
	}

	public void setProdutos(Map<Long, Integer> itens) {
		this.produtos = itens;
	}
}