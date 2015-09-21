import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfComMuitaSorte(){
        IrishDwarf irishDwarf = new IrishDwarf("IrishDwarf", new DataTerceiraEra(1,1,4));
        for(int i = 0; i < 2; i++) {
            irishDwarf.receberFlechada();
        }
        Item pocao = new Item("Poçao", 3);
        Inventario inventario = new Inventario();
        irishDwarf.adicionarItemDwarf(pocao);
        irishDwarf.tentarSorte();
        assertEquals(6003, irishDwarf.getInventario().getItem(0).getQuantidade());        
    }
    
    @Test
    public void irishDwarfComMuitaSorte2(){
        IrishDwarf irishDwarf = new IrishDwarf("IrishDwarf", new DataTerceiraEra(1,1,4));
        for(int i = 0; i < 2; i++) {
            irishDwarf.receberFlechada();
        }
        Item pocao = new Item("Poçao", 4);
        Inventario inventario = new Inventario();
        irishDwarf.adicionarItemDwarf(pocao);
        irishDwarf.tentarSorte();
        assertEquals(10004, irishDwarf.getInventario().getItem(0).getQuantidade());        
    }
    
    @Test
    public void irishDwarfComMuitaSorte3(){
        IrishDwarf irishDwarf = new IrishDwarf("IrishDwarf", new DataTerceiraEra(1,1,4));
        for(int i = 0; i < 2; i++) {
            irishDwarf.receberFlechada();
        }
        Item pocao = new Item("Poçao", 6);
        Inventario inventario = new Inventario();
        irishDwarf.adicionarItemDwarf(pocao);
        irishDwarf.tentarSorte();
        assertEquals(21006, irishDwarf.getInventario().getItem(0).getQuantidade());        
    }
}
