package br.edu.ifpb.daweb.herllan.projetoDAWEB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoDawebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDawebApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Hello World!");
	}

}
