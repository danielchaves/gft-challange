package br.com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gft.model.Periodo;
import br.com.gft.model.Prato;
import br.com.gft.model.TipoPrato;
import br.com.gft.repository.PratoRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RefeicaoServiceTest {

    @Autowired
	private PratoRepository pratoRepository;
    
    @Autowired
    private RefeicaoService refeicaoService; 
 
//    @Before
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
    
//    @Test
    public void testEntrada01() throws Exception {
    	    	
    	String retorno = refeicaoService.pedirRefeicao("manhã", "1,2,3");
    	
    	assertEquals(retorno, "ovos, torrada, café");
    }
    
    
    
    

}

