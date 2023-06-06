package br.ucsal.loja.client;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.cloud.openfeign.FeignClient(name = "transportadora", url="http://localhost:8081/api/transportadora/")
public interface ClientTransportadora {

	@PostMapping("solicitarTransporte")
	public Map<Long,Integer> solicitarTransporte(@RequestBody Map<Long,Integer> pedido);
	
}