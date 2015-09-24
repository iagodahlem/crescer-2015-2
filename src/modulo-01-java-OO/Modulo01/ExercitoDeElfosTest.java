import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest
{
    @Test 
    public void alistarUmElfoVerdeNoExercitoDeElfos() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(new ElfoVerde("Elfo Verde"));
        assertEquals(1, exercito.getQuantidadeSoldadosAlistados());
    }
}
