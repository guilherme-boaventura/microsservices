package br.ucsal.armazem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.armazem.model.Estoque;
import br.ucsal.armazem.repository.EstoqueRepository;

@Service
public class EstoqueService {

	
	
	@Autowired
	private EstoqueRepository repo;
	
	public void armazenar(Map<Long,Integer> entrega) {
		for (Map.Entry<Long, Integer> entry : entrega.entrySet()) {
			Long idProduto = Long.valueOf(entry.getKey());
			Estoque e = repo.findById(idProduto).get();
			
			Integer quantidade = (Integer)entry.getValue();
			e.setQuantidade(e.getQuantidade()+quantidade);
			
			this.repo.save(e);	
		}
	}

	public List<Long> checarEstoque(Map<Long, Integer> compra) {
		List<Long> faltantes = new ArrayList<Long>();
		
		for (Map.Entry<Long, Integer> entry : compra.entrySet()) {
	        Long idProduto = entry.getKey();
	        Integer quantidade = entry.getValue();

	        Estoque estoque = repo.findById(idProduto).get();
	        if (estoque.getQuantidade() < quantidade) {
	            faltantes.add(estoque.getIdProduto());
	        }
	    }
		
		if(faltantes.isEmpty()) {
			realizarVenda(compra);
		}
		
	    return faltantes; 
	}

	public void realizarVenda(Map<Long, Integer> compra) {
		for (Map.Entry<Long, Integer> entry : compra.entrySet()) {
	        Long idProduto = entry.getKey();
	        Integer quantidade = entry.getValue();

	        Estoque estoque = repo.findById(idProduto).get();
	        estoque.setQuantidade(estoque.getQuantidade()-quantidade);
	        repo.save(estoque);
	    }
	}
}