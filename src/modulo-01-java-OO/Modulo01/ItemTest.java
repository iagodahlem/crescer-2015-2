import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void itemRecebeDescricaoNullEQuantidade0() {
        Item item = new Item();
        assertEquals(null, item.getDescricao());
        assertEquals(0, item.getQuantidade());
    }
    
    @Test
    public void itemRecebeDescricaoDiferenteDeNullEQuantidadeDiferenteDe0() {
        Item item = new Item("espada", 1);
        assertEquals("espada", item.getDescricao());
        assertEquals(1, item.getQuantidade());
    }
}
