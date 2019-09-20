package br.com.pamcary.desafio.aluno;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init() {
        return args -> {            
            System.out.println("teste");
        };
    }
}

