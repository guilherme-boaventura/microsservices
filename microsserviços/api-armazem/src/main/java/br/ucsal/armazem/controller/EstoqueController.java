package br.ucsal.armazem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.armazem.service.EstoqueService;

@RestController
@RequestMapping("api/armazem")
public class EstoqueController {

	@Autowired
	private EstoqueService serv;
	
	@PostMapping("/armazenar")
	public void receberEntrega(@RequestBody Map<Long,Integer> remessa) {
		serv.armazenar(remessa);
	}
	
	@PostMapping("/checarEstoque")
	public List<Long> checarEstoque(@RequestBody Map<Long,Integer> compra) {
		List<Long> faltantes = serv.checarEstoque(compra);
		return faltantes;
	}
}