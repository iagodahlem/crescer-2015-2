import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    // AAA
    // Arrange
    // Act
    // Assert
    
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
    
    @Test
    public void dwarfRecebe11FlechasEVidaÉ0() {
        Dwarf gimli = new Dwarf();
        for(int i = 0; i < 11; i++) {
            gimli.receberFlechada();
        }
        assertEquals(0, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebe7FlechaVezesEVidaÉ40() {
        Dwarf gimli = new Dwarf();
        for(int i = 0; i < 7; i++) {
            gimli.receberFlechada();
        }
        assertEquals(40, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebeStatusMorto() {
        Dwarf gloin = new Dwarf();
        for (int i = 0; i < 11; i++) {
            gloin.receberFlechada();
        }
        assertEquals(Status.MORTO, gloin.getStatus());
    }
}