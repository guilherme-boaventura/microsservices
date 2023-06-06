package br.ucsal.transportadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiTransportadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTransportadoraApplication.class, args);
	}

}