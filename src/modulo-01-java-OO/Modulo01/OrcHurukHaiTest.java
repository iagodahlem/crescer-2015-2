import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcHurukHaiTest
{
    @Test
    public void orcHurukHaiRecebeVida150() {
        OrcHurukHai urukHai = new OrcHurukHai();
        assertEquals(150, urukHai.getVida());
    }
    
    @Test
    public void orcHurukHaiRecebe1EscudoE1Espada() {
        OrcHurukHai uruk = new OrcHurukHai();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Escudo Uruk-Hai", 1));
        esperado.adicionarItem(new Item("Espada", 1));
        assertEquals(esperado, uruk.getInventario());
    }
}
