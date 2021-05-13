package br.miranda.zup.proposta.desafioDeProposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioDePropostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioDePropostaApplication.class, args);
	}

}
