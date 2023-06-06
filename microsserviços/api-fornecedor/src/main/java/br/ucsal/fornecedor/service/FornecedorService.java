package br.ucsal.fornecedor.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.ucsal.fornecedor.model.Produto;
import br.ucsal.fornecedor.repository.ProdutoRepository;

@Service
public class FornecedorService {

	@Autowired
	private ProdutoRepository repo;

	public int calcularValorTotal(Map<Long, Integer> prodQtd) {
		int valorTotal = 0;

		for (Map.Entry<Long, Integer> entry : prodQtd.entrySet()) {
			Long produtoId = entry.getKey();
			Integer quantidade = entry.getValue();

			Produto produto = repo.findById(produtoId).get();
			int valorProduto = produto.getValor();
			valorTotal += valorProduto * quantidade;
		}
		
		return valorTotal;
	}
}