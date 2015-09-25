import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test 
    public void elfoNoturnoAtiraFlechaEGanha3DeExperiencia() {
        ElfoNoturno noturno = new ElfoNoturno("noturno");
        Dwarf dwarf = new Dwarf();
        noturno.atirarFlecha(dwarf);
        assertEquals(3, noturno.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoAtiraFlechaEPerde5PorCentoDeVida() {
        ElfoNoturno noturno = new ElfoNoturno("noturno");
        Dwarf dwarf = new Dwarf();
        noturno.atirarFlecha(dwarf);
        assertEquals(95, noturno.getVida(), 0.0);
    }
    
    @Test
    public void elfoNoturnoAtiraDuasFlechasEPerde5PorCentoDeVidaDuasVezes() {
        ElfoNoturno noturno = new ElfoNoturno("noturno");
        Dwarf dwarf = new Dwarf();
        noturno.atirarFlecha(dwarf);
        noturno.atirarFlecha(dwarf);
        assertEquals(90.25, noturno.getVida(), 00001);
    }
    
    @Test 
    public void elfoNoturnoAtira15FlechasEMorre() {
        ElfoNoturno noturno = new ElfoNoturno("noturno");
        Dwarf dwarf = new Dwarf();
        for (int i = 0; i < 12; i++) {
            noturno.atirarFlecha(dwarf);
        }
    }
}
