package br.ucsal.armazem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiArmazemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiArmazemApplication.class, args);
	}

}
