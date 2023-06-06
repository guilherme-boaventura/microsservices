package br.ucsal.loja.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.loja.service.VendaService;

@RestController
@RequestMapping("api/loja")
public class VendaController {
	
	@Autowired
	private VendaService serv;
	
	@PostMapping("/comprar")
	public Object comprar(@RequestParam("itens") List<Long> itens,
			 			  @RequestParam("quantidade") List<Integer> quantidade) {
		Map<Long,Integer> venda = new HashMap<Long,Integer>();
		
		for (int i = 0; i < itens.size(); i++) {
			venda.put(itens.get(i), quantidade.get(i));
		}
		
		Object retorno = serv.checarEstoque(venda);
		return retorno;
	}
	
	@GetMapping("ok")
	public String ok() {
		return "ok";
	}
}