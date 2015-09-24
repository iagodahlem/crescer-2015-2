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
    
    @Test
    public void retornaElfoAlistadoPeloNome() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde greenLegolas = new ElfoVerde("Green Legolas");
        exercito.alistar(greenLegolas);
        Elfo elfoObtido = exercito.buscarElfoPorNome("Green Legolas");
        assertEquals(greenLegolas, elfoObtido);
    }
    
    @Test
    public void alista2ElfosVivosEOrdenaPeloStatus() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistar(new ElfoVerde("Elfo Verde"));
        exercito.alistar(new ElfoNoturno("Night Elfo"));
        exercito.agruparPorStatus();
    }
}
