package br.ucsal.transportadora.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.transportadora.model.Frete;
import br.ucsal.transportadora.repository.FreteRepository;

@Service
public class FreteService {
	
	@Autowired
	private FreteRepository repo;
	
	public Frete novoFrete(Map<Long,Integer> pedido) {
		Frete frete = new Frete(pedido,(int)calcularNumVeiculos(pedido));
		
		this.repo.save(frete);
		
		return frete;
	}

	private double calcularNumVeiculos(Map<Long,Integer> itensQuantidade) {
		double TotalNumItens = 0;
		for (Map.Entry<Long, Integer> entry : itensQuantidade.entrySet()) {
			Integer val = entry.getValue();
			TotalNumItens += val;
		}
		return Math.ceil(TotalNumItens/50);
	}
}