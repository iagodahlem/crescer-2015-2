import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void irishDwarfComSorte() {
        IrishDwarf dwarf = new IrishDwarf("Leprechaun sortudo", new DataTerceiraEra(1, 1, 2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.adicionarItem(new Item("Lança", 5));
        dwarf.adicionarItem(new Item("Poção", 25));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Lança", 15005));
        esperado.adicionarItem(new Item("Poção", 325025));
        dwarf.tentarSorte();
        assertEquals(esperado, dwarf.getInventario());
    }

}
