package br.com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gft.model.Periodo;
import br.com.gft.model.Prato;
import br.com.gft.model.TipoPrato;
import br.com.gft.repository.PratoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class RefeicaoServiceTest {

    @Autowired
	private PratoRepository pratoRepository;
    
    @Autowired
    private RefeicaoService refeicaoService; 
     
    @Before
    public void setup() throws Exception {

        this.pratoRepository.deleteAllInBatch();
        
        Prato p01 = new Prato("ovos", TipoPrato.ENTRADA, Periodo.MANHA, false);
        Prato p02 = new Prato("torrada", TipoPrato.ACOMPANHAMENTO, Periodo.MANHA, false);
        Prato p03 = new Prato("café", TipoPrato.BEBIDA, Periodo.MANHA, true);
        
        Prato p11 = new Prato("carne", TipoPrato.ENTRADA, Periodo.NOITE, false);
        Prato p12 = new Prato("batata", TipoPrato.ACOMPANHAMENTO, Periodo.NOITE, true);
        Prato p13 = new Prato("vinho", TipoPrato.BEBIDA, Periodo.NOITE, false);
        Prato p14 = new Prato("bolo", TipoPrato.SOBREMESA, Periodo.NOITE, false);
        
        pratoRepository.save(p01);
        pratoRepository.save(p02);
        pratoRepository.save(p03);
        
        pratoRepository.save(p11);
        pratoRepository.save(p12);
        pratoRepository.save(p13);
        pratoRepository.save(p14);
        
    }
    
    @Test
    public void testEntrada01() throws Exception {
    	
    	System.out.println("#######################");
        System.out.println("");
        System.out.println("# TESTE UNITÁRIO 01");
        System.out.println("");
    	    	
    	String periodo = "manhã";
		String pedido = "1,2,3";
		String retorno = refeicaoService.pedirRefeicao(periodo, pedido);
    	
    	System.out.println("Entrada: " + periodo + ", " + pedido);
    	
    	String respostaEsperada = "ovos, torrada, café";
		assertEquals(retorno, respostaEsperada);
		
		System.out.println("Saída: " + retorno);
    }
    
    @Test
    public void testEntrada02() throws Exception {
    	
    	System.out.println("#######################");
        System.out.println("");
        System.out.println("# TESTE UNITÁRIO 02");
        System.out.println("");
    	    	
    	String periodo = "manhã";
		String pedido = "2,1,3";
		String retorno = refeicaoService.pedirRefeicao(periodo, pedido);
    	
    	System.out.println("Entrada: " + periodo + ", " + pedido);
    	
    	String respostaEsperada = "ovos, torrada, café";
		assertEquals(retorno, respostaEsperada);
		
		System.out.println("Saída: " + retorno);
    }
    
    @Test
    public void testEntrada03() throws Exception {
    	
    	System.out.println("#######################");
        System.out.println("");
        System.out.println("# TESTE UNITÁRIO 03");
        System.out.println("");
    	    	
    	String periodo = "manhã";
		String pedido = "1,2,3,4";
		String retorno = refeicaoService.pedirRefeicao(periodo, pedido);
    	
    	System.out.println("Entrada: " + periodo + ", " + pedido);
    	
    	String respostaEsperada = "ovos, torrada, café, erro";
		assertEquals(retorno, respostaEsperada);
		
		System.out.println("Saída: " + retorno);
    }
    
    @Test
    public void testEntrada04() throws Exception {
    	
    	System.out.println("#######################");
        System.out.println("");
        System.out.println("# TESTE UNITÁRIO 04");
        System.out.println("");
    	    	
    	String periodo = "manhã";
		String pedido = "1,2,3,3,3";
		String retorno = refeicaoService.pedirRefeicao(periodo, pedido);
    	
    	System.out.println("Entrada: " + periodo + ", " + pedido);
    	
    	String respostaEsperada = "ovos, torrada, café (x3)";
		assertEquals(retorno, respostaEsperada);
		
		System.out.println("Saída: " + retorno);
    }
    
    @Test
    public void testEntrada05() throws Exception {
    	
    	System.out.println("#######################");
        System.out.println("");
        System.out.println("# TESTE UNITÁRIO 05");
        System.out.println("");
    	    	
    	String periodo = "noite";
		String pedido = "1,2,3,4";
		String retorno = refeicaoService.pedirRefeicao(periodo, pedido);
    	
    	System.out.println("Entrada: " + periodo + ", " + pedido);
    	
    	String respostaEsperada = "carne, batata, vinho, bolo";
		assertEquals(retorno, respostaEsperada);
		
		System.out.println("Saída: " + retorno);
    }
    
    @Test
    public void testEntrada06() throws Exception {
    	
    	System.out.println("#######################");
        System.out.println("");
        System.out.println("# TESTE UNITÁRIO 06");
        System.out.println("");
    	    	
    	String periodo = "noite";
		String pedido = "1,2,2,4";
		String retorno = refeicaoService.pedirRefeicao(periodo, pedido);
    	
    	System.out.println("Entrada: " + periodo + ", " + pedido);
    	
    	String respostaEsperada = "carne, batata (x2), bolo";
		assertEquals(retorno, respostaEsperada);
		
		System.out.println("Saída: " + retorno);
    }
    

}

