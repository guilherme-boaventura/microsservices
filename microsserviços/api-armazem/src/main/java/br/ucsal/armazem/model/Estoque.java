package br.ucsal.armazem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estoque")
public class Estoque {
	
	@Id
	private Long idProduto;
	private Long quantidade;
	
	public Estoque() {
		
	}

	public Estoque(Long idProduto, Long quantidade) {
		this();
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
	public Long getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
}
