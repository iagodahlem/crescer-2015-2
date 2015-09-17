import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNome() {
        Elfo elf = new Elfo("");
        assertNotNull(elf.getNome());
    }
    
    @Test
    public void elfoCriadoComNomeNasceCom42Flechas() {
        Elfo elf = new Elfo("Elf");
        assertEquals(42, elf.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeNull() {
        Elfo elf = new Elfo(null);
        assertNull(elf.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        Elfo elf = new Elfo("");
        assertEquals("", elf.getNome());
    }
    
    @Test
    public void elfoAtiraFlechaEPerde1Flecha() {
        Elfo elf = new Elfo("Elf");
        Dwarf gimli = new Dwarf();
        elf.atirarFlecha(gimli);
        assertEquals(41, elf.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEGanha1DeExperiencia() {
        Elfo elf = new Elfo("Elf");
        Dwarf gimli = new Dwarf();
        elf.atirarFlecha(gimli);
        assertEquals(1, elf.getExperiencia());
    }
}
