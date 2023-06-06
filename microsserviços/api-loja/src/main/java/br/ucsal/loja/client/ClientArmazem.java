package br.ucsal.loja.client;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.cloud.openfeign.FeignClient(name = "armazem", url="http://localhost:8082/api/armazem")
public interface ClientArmazem {

	@PostMapping("/checarEstoque")
	public List<Long> checarEstoque(@RequestBody Map<Long,Integer> compra);
	
	@PostMapping("/armazenar")
	public void armazenar(@RequestBody Map<Long,Integer> remessa);
}