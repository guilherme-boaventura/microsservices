package br.ucsal.fornecedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiFornecedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFornecedorApplication.class, args);
	}

}
 