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
    
    @Test 
    public void dwarfRecebeNomeEDataDeNascimento() {
        Dwarf gloin = new Dwarf("Gloin", new DataTerceiraEra(10, 10, 1995));
        DataTerceiraEra dataNascimento = gloin.getDataDeNascimento();
        assertEquals("Gloin", gloin.getNome());
        assertEquals(10, dataNascimento.getDia());
        assertEquals(10, dataNascimento.getMes());
        assertEquals(1995, dataNascimento.getAno());
    }
    
    @Test
    public void dwarfRecebeDataDeNascimentoDefault() {
        Dwarf gloin = new Dwarf("Gloin");
        DataTerceiraEra dataNascimento = gloin.getDataDeNascimento();
        assertEquals(1, dataNascimento.getDia());
        assertEquals(1, dataNascimento.getMes());
        assertEquals(1, dataNascimento.getAno());
    }
    
    @Test
    public void dwarfTemNumeroDaSorteMenos3333() {
        Dwarf gloin = new Dwarf("Gloin", new DataTerceiraEra(1, 1, 4));
        for(int i = 0; i < 3; i++) {
            gloin.receberFlechada();
        }
        DataTerceiraEra dataNascimento = gloin.getDataDeNascimento();
        assertEquals(-3333, gloin.getNumeroSorte(), 0);
    }
    
    @Test
    public void dwarfRecebe1Item() {
        Dwarf dwarf = new Dwarf("dwarf");
        Item marreta = new Item("marreta", 1);
        dwarf.adicionarItemDwarf(marreta);
        assertEquals(1, dwarf.getInventarioDwarf());
    }
    
    @Test
    public void dwarfRecebe2ItensEPerde1Item() {
        Dwarf dwarf = new Dwarf("dwarf");
        Item marreta = new Item("marreta", 1);
        Item pocao = new Item("vidaInfinita", 1);
        dwarf.adicionarItemDwarf(marreta);
        dwarf.adicionarItemDwarf(pocao);
        dwarf.perderItemDwarf(pocao);
        assertEquals(1, dwarf.getInventarioDwarf());
    }
}