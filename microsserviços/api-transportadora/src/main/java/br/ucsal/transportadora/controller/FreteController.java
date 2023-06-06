package br.ucsal.transportadora.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.transportadora.service.FreteService;

@RestController
@RequestMapping("api/transportadora")
public class FreteController {

	@Autowired
	private FreteService serv;
	
	@PostMapping("/solicitarTransporte")
	public Map<Long,Integer> solicitarTransporte(@RequestBody Map<Long,Integer> pedido){	
		return serv.novoFrete(pedido).getItens();
	}
	
	@GetMapping("ok")
	public String ok() {
		return "ok";
	}
	
}