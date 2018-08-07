package br.com.gft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gft.service.RefeicaoService;

@SpringBootApplication
public class GftTestApplication {

	private static Logger LOG = LoggerFactory.getLogger(GftTestApplication.class);
	
	@Autowired
	RefeicaoService refeicaoService;

	public static void main(String[] args) {
		LOG.info("##########################");
		LOG.info("#");
		LOG.info("# INICIANDO APLICATIVO...");
		LOG.info("#");
		LOG.info("##########################");
		SpringApplication.run(GftTestApplication.class, args);
		LOG.info("##########################");
		LOG.info("#");
		LOG.info("# APLICATIVO ENCERRADO");
		LOG.info("#");
		LOG.info("##########################");
	}

}