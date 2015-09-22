import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{
    @Test
    public void inventarioRecebeItem() {
        Item computador = new Item("computador", 1);
        Inventario mochila = new Inventario();
        mochila.adicionarItem(computador);
        assertEquals(1, mochila.getItens().size());
    }
    
    @Test
    public void inventarioRecebe50Itens() {
        Item pocao = new Item("pocao", 1);
        Inventario inventario = new Inventario();
        for (int i = 0; i < 50; i++) {
            inventario.adicionarItem(pocao);
        }
        assertEquals(50, inventario.getItens().size());
    }
    
    @Test
    public void inventarioRecebe2ItensEPerde1() {
        Item item1 = new Item("item1", 45);
        Item item2 = new Item("item2", 7);
        Inventario inventario = new Inventario();
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.perderItem(item1);
        assertEquals(1, inventario.getItens().size());
    }
    
    @Test 
    public void inventarioRecebe1ItemEPerde1Item() {
        Item bala = new Item("balas", 42);
        Inventario maleta = new Inventario();
        maleta.adicionarItem(bala);
        maleta.perderItem(bala);
        assertEquals(0, maleta.getItens().size());
    }
    
    @Test
    public void inventarioRecebe2ItensEPerde2Itens() {
        Item bala = new Item("balas", 42);
        Item metralhadora = new Item("uzi", 1);
        Inventario maleta = new Inventario();
        maleta.adicionarItem(bala);
        maleta.adicionarItem(metralhadora);
        maleta.perderItem(bala);
        maleta.perderItem(metralhadora);
        assertEquals(0, maleta.getItens().size());
    }
    
    @Test
    public void inventarioRetornaItemComMaiorQuantidade() {
        Item bala = new Item("balas", 42);
        Item metralhadora = new Item("uzi", 1);
        Inventario maleta = new Inventario();
        maleta.adicionarItem(bala);
        maleta.adicionarItem(metralhadora);
        assertEquals(maleta.getItens().get(0), maleta.getItemComMaiorQuantidade());
    }
}