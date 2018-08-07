package br.com.gft;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.gft.service.RefeicaoService;

@Component
@Profile("!test")
public class GftTestCommanLineRunner implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(GftTestCommanLineRunner.class);
	
	@Autowired
	private RefeicaoService refeicaoService;

	@Override
	public void run(String... args) {
		
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("##########################");
			System.out.println("");
			System.out.println("- Informe o período [manhã / noite]:");
			Pattern patternPeriodo = Pattern.compile("^manh(ã|Ã)|noite$", Pattern.CASE_INSENSITIVE);			
			String periodo = scanner.next(patternPeriodo);
			System.out.println("");
			System.out.println("Informe os pratos da refeição [número separado por vírgula]: ");
			Pattern patternPratos = Pattern.compile("^[1-4](,[1-4])*$");
			String pratos = scanner.next();
			pratos = pratos.trim();
			if(!patternPratos.matcher(pratos).matches()) {
				System.out.println("Valor de entrada não permitido.");
				System.exit(1);
			}			
			
			System.out.println("##########################");
			System.out.println("");
			System.out.println("Entrada: " + periodo + ", " + pratos);
			
			System.out.println("##########################");
			System.out.println("");
			System.out.println("Saída: " + refeicaoService.pedirRefeicao(periodo, pratos)); 
			
		} catch (InputMismatchException e) {
			System.out.println("Valor de entrada não permitido.");
		} finally {
			scanner.close();
		}
	}

}
