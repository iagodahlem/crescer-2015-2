import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void elfoNasceComNomeEFlechasSetadosPeloUsuario() {
        Elfo elf = new Elfo("", 0);
        assertNotNull(elf.getNome());
    }
    
    @Test
    public void elfoNasceCom42Flechas() {
        Elfo elf = new Elfo("Elf");
        assertEquals(42, elf.getFlechas());
    }
}
