package br.ucsal.loja.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.loja.client.ClientArmazem;
import br.ucsal.loja.client.ClientFornecedor;
import br.ucsal.loja.client.ClientTransportadora;
import br.ucsal.loja.model.Venda;
import br.ucsal.loja.repository.VendaRepository;

@Service
public class VendaService {
	
	private final Integer QUANTIDADE_DE_ITENS = 100;
	
	@Autowired
	private ClientArmazem cliArm;
	
	@Autowired
	private ClientFornecedor cliForn;

	@Autowired
	private ClientTransportadora cliTrans;
	
	@Autowired
	private VendaRepository repo;

	public Object checarEstoque(Map<Long,Integer> venda) {
		List<Long> faltantes = cliArm.checarEstoque(venda);
		if(!faltantes.isEmpty()){
			Map<Long,Integer> pedido = montarPedido(faltantes);
			
			Integer valorPedido = cliForn.pedido(pedido);
			
			if(cliForn.enviarPagamento(valorPedido,valorPedido)) {
				Map<Long,Integer> remessa = cliTrans.solicitarTransporte(pedido);
				cliArm.armazenar(remessa);
			}else {
				return "O valor do pedido não foi pago corretamente";
			}
			
			return "Não temos estoque do produto solicitado, o seguinte pedido já foi feito ao fornecedor: \n" + pedido.toString() + "\n valor: " + valorPedido;
		}else {
			Venda registro = new Venda(venda);
			repo.save(registro);
			return venda;
		}
	}
	
	private Map<Long,Integer> montarPedido(List<Long> idFaltantes) {
		Map<Long,Integer> pedido = new HashMap<Long,Integer>();
		for (Long id : idFaltantes) {
			pedido.put(id, QUANTIDADE_DE_ITENS);
		}
		return pedido;
	}
}