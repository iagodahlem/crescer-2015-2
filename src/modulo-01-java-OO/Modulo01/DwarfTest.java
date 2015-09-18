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
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechadaEPerde10DeVida() {
        Dwarf gimli = new Dwarf("Gimli");
        gimli.receberFlechada();
        assertEquals(100, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebe11FlechasEVidaÉ0() {
        Dwarf gimli = new Dwarf("Gimli");
        for(int i = 0; i < 11; i++) {
            gimli.receberFlechada();
        }
        assertEquals(0, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebe7FlechaVezesEVidaÉ40() {
        Dwarf gimli = new Dwarf("Gimli");
        for(int i = 0; i < 7; i++) {
            gimli.receberFlechada();
        }
        assertEquals(40, gimli.getVida());
    }
    
    @Test
    public void dwarfRecebeStatusMorto() {
        Dwarf gloin = new Dwarf("Gloin");
        for (int i = 0; i < 11; i++) {
            gloin.receberFlechada();
        }
       assertEquals(Status.MORTO, gloin.getStatus());
    }
    
    /*
    @Test 
    public void dwarfRecebeNomeEDataDeNascimento() {
        Dwarf gloin = new Dwarf("Gloin", new DataTerceiraEra(10, 10, 1995));
        assertEquals("Gloin", gloin.getNome());
        assertEquals(new DataTerceiraEra(10, 10, 1995), gloin.getDataDeNascimento());
    }
    */
    
   /*
    @Test
    public void dwarfRecebeDataDeNascimentoDefault() {
    
    }
    */
}