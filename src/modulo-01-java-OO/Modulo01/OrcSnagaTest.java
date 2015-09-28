import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcSnagaTest
{
    @Test
    public void orcSnagaRecebe70() {
        OrcSnaga snaga = new OrcSnaga();
        assertEquals(70, snaga.getVida(), 0.0);
    }
    
    @Test
    public void orcSnagaRecebeInventarioCom1ArcoE5Flechas() {
        OrcSnaga snaga = new OrcSnaga();
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Arco", 1));
        esperado.adicionarItem(new Item("Flecha", 5));
        assertEquals(esperado, snaga.getInventario());
    }
}
