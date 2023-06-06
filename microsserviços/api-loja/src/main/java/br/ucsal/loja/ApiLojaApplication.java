package br.ucsal.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiLojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLojaApplication.class, args);
	}

}
