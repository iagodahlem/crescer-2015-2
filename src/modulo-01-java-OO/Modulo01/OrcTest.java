import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest
{
@Test
    public void criaUrukHai(){
        OrcHurukHai orcHurukHai = new OrcHurukHai();
        
        int vidaEsperada = 150;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Escudo Uruk-Hai", 1));
        inventarioEsperado.adicionarItem(new Item("Espada", 1));
        
        assertEquals(vidaEsperada, orcHurukHai.getVida());
        assertEquals(inventarioEsperado, orcHurukHai.getInventario());
    }
    
    @Test
    public void criaSnaga(){
        OrcSnaga orcSnaga = new OrcSnaga();
        
        int vidaEsperada = 70;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Arco", 1));
        inventarioEsperado.adicionarItem(new Item("Flecha", 5));
        
        assertEquals(vidaEsperada, orcSnaga.getVida());
        assertEquals(inventarioEsperado, orcSnaga.getInventario());
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeAnao(){
        OrcHurukHai orcHurukHai = new OrcHurukHai();
        
        orcHurukHai.levarAtaqueDeAnao();
        
        assertEquals(145, orcHurukHai.getVida());
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeElfo(){
        OrcHurukHai orcHurukHai = new OrcHurukHai();
        
        orcHurukHai.levarAtaqueDeElfo();
        
        assertEquals(142, orcHurukHai.getVida());
    }
    
    @Test
    public void orcSnagaRecebeDanoDeAnao(){
        OrcSnaga orcSnaga = new OrcSnaga();
        
        orcSnaga.levarAtaqueDeAnao();
        
        assertEquals(60, orcSnaga.getVida());
    }
    
    @Test
    public void orcSnagaRecebeDanoDeElfo(){
        OrcSnaga orcSnaga = new OrcSnaga();
        
        orcSnaga.levarAtaqueDeElfo();
        
        assertEquals(62, orcSnaga.getVida());
    }
    
    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        OrcSnaga orcSnaga = new OrcSnaga();
        Elfo elfo = new Elfo(null);
        
        for(int i = 0; i < 6; i++){
            orcSnaga.atacarElfo(elfo);
        }
        
        assertEquals(Status.FUGINDO, orcSnaga.getStatus());
    }
    
    @Test
    public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){
    
        OrcSnaga orcSnaga = new OrcSnaga();
        Elfo elfo = new Elfo(null);
        
        orcSnaga.atacarElfo(elfo);
        
        int qtdFlechas = orcSnaga.getInventario().getItemPorDescricao("Flecha").getQuantidade();
        
        assertEquals(4, qtdFlechas);
        
    }
}
