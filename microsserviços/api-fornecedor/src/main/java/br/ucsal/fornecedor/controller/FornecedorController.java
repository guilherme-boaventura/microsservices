package br.ucsal.fornecedor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.fornecedor.service.FornecedorService;

@RestController
@RequestMapping("api/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping("/pedido")
	public Integer pedido(@RequestBody Map<Long, Integer> pedido) {
		int valorTotal = fornecedorService.calcularValorTotal(pedido);
		return valorTotal;
	}
	
	@GetMapping("/receberPagamento")
	public boolean receberPagamento(@RequestParam("valorPago") Integer valorPago,
			  						@RequestParam("valorPedido") Integer valorPedido) {
		if(valorPago >= valorPedido) {
			return true;
		}else {
			return false;
		}
	}
	
}