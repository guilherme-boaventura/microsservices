package br.ucsal.loja.client;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.cloud.openfeign.FeignClient(name = "fornecedor", url="http://localhost:8085/api/fornecedor")
public interface ClientFornecedor {
	
	@PostMapping("/pedido")
	public Integer pedido(@RequestBody Map<Long,Integer> pedido);

	@GetMapping("/receberPagamento")
	public boolean enviarPagamento(@RequestParam("valorPago") Integer valorPago,
						  		   @RequestParam("valorPedido") Integer valorPedido);
	
}