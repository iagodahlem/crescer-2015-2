import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida() {
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechadaEPerde10DeVida() {
        Dwarf gimli = new Dwarf();
        gimli.receberFlechada();
        assertEquals(100, gimli.getVida());
    }
}