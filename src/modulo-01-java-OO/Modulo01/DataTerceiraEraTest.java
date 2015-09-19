import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAno() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(1,1,1);
        assertEquals(1, primeiroDia.getDia());
        assertEquals(1, primeiroDia.getMes());
        assertEquals(1, primeiroDia.getAno());
    }
    
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAnoNegativo() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(-1,-1,-1);
        assertEquals(-1, primeiroDia.getDia());
        assertEquals(-1, primeiroDia.getMes());
        assertEquals(-1, primeiroDia.getAno());
    }
    
    @Test
    public void dataTerceiraEraÉCriadaComDiaMesAnoZerado() {
        DataTerceiraEra primeiroDia = new DataTerceiraEra(0,0,0);
        assertEquals(0, primeiroDia.getDia());
        assertEquals(0, primeiroDia.getMes());
        assertEquals(0, primeiroDia.getAno());
    }
    
    @Test 
    public void anoÉBissexto() {
       DataTerceiraEra bissexto = new DataTerceiraEra(1, 1, 4);
       assertEquals(true, bissexto.ehBissexto());
    }
    
    @Test
    public void anoNaoÉBissexto() {
        DataTerceiraEra naoBissexto = new DataTerceiraEra(1, 1, 1);
        assertEquals(false, naoBissexto.ehBissexto());
    }
}
