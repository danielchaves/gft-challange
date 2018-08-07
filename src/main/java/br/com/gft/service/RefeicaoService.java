package br.com.gft.service;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.gft.model.Periodo;
import br.com.gft.model.Prato;
import br.com.gft.model.TipoPrato;
import br.com.gft.repository.PratoRepository;

@Service
public class RefeicaoService {
	
	private PratoRepository pratoRepository;
	
	public RefeicaoService(PratoRepository pratoRepository) {
		super();
		this.pratoRepository = pratoRepository;
	}

	public String pedirRefeicao(String periodo, String pedido) {
		String retorno = "";
		
		int[] pedidosOrdenados = Stream.of(pedido.split(",")).mapToInt(s -> Integer.valueOf(s)).sorted().toArray();
		
		Pattern p = Pattern.compile("MANH", Pattern.CASE_INSENSITIVE);
		Periodo periodoEnum;
		if (p.matcher(periodo).find()) {
			periodoEnum = Periodo.MANHA;
		} else {
			periodoEnum = Periodo.NOITE;
		}
				
		Prato pratoExemplo = new Prato();
		pratoExemplo.setPeriodo(periodoEnum);
		int multiplica = 1;
		String multiplicador = "";
		Prato prato = null;
		for (int i : pedidosOrdenados) {
			TipoPrato tp = TipoPrato.getByCodigo(i);
			if(tp.equals(pratoExemplo.getTipoPrato())) {
				multiplica++;
				multiplicador = " (x" + multiplica + ")";
				continue;
			} else {
				pratoExemplo.setTipoPrato(tp);
				if (multiplicador.length() > 0) {					
					String nomeAnterior = prato.getNome();
					Pattern nomePattern = Pattern.compile(nomeAnterior, Pattern.LITERAL);
					if (nomePattern.matcher(retorno).find()) {
						if (prato.getPodeRepetir()) {
							retorno = retorno.substring(0, retorno.length() - 2);
							retorno += multiplicador + ", ";
						} else {
							retorno += "erro, ";
						}
					}
				}
				
				prato = pratoRepository.findOne(Example.of(pratoExemplo));
				if (prato != null) {
						retorno += prato.getNome() + ", ";
					
				} else {
					retorno += "erro, ";
				}
				multiplicador = "";
				multiplica = 1;
			}
			
		}
		if (multiplicador.length() > 0) {					
			String nomeAnterior = prato.getNome();
			Pattern nomePattern = Pattern.compile(nomeAnterior, Pattern.LITERAL);
			if (nomePattern.matcher(retorno).find()) {
				if (prato.getPodeRepetir()) {
					retorno = retorno.substring(0, retorno.length() - 2);
					retorno += multiplicador + ", ";
				} else {
					retorno += "erro, ";
				}
			}
		}
		retorno = retorno.substring(0, retorno.length() - 2);
		
		//retorno = IntStream.of(pedidosOrdenados).mapToObj(String::valueOf).collect(Collectors.joining(","));
		
		return retorno;
	}

}
