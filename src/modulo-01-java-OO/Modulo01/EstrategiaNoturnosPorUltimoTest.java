import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNoturnosPorUltimoTest
{
    @Test
    public void testeDeElfosNoturnosPorUltimo() {
        // Arrange
        Dwarf balin = new Dwarf("Balin");
        Dwarf stalin = new Dwarf("Stalin");
        double vidaEsperada = 80;
        Elfo noturno1 = new ElfoNoturno("Night Elf1");
        Elfo noturno2 = new ElfoNoturno("Night Elf2");
        Elfo noturno3 = new ElfoNoturno("Night Elf3");
        Elfo verde1 = new ElfoVerde("Green 1");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alterarEstrategia(new EstrategiaNoturnosPorUltimo());
        exercito.alistar(noturno1);
        exercito.alistar(noturno2);
        exercito.alistar(noturno3);
        exercito.alistar(verde1);
        
        // Act
        exercito.atacar(new ArrayList<Dwarf>(Arrays.asList(balin, stalin)));
        
        // Assert
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();

        /*
        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof ElfoNoturno) {
                noturnosQueAtiraram++;
            }
        }
        */

        //assertEquals(2, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);

    }
}
