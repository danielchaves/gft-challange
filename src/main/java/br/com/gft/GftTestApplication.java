package br.com.gft;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GftTestApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(GftTestApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(GftTestApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {

		try {
			System.out.println("Informe o período [manhã / noite]");
			Scanner scanner = new Scanner(System.in);
			String periodo = scanner.next("(?:^)(manhã|noite)(?:$)");
			
			System.out.println("Periodo selecionado: " + periodo);
		} catch (InputMismatchException e) {
			System.out.println("Valor de entrada não permitido. ERRO: " + e.getMessage());
		}

	}
}