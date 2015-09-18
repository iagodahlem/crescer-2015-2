import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
   @Test 
   public void anoEhBissexto() {
       DataTerceiraEra bissexto = new DataTerceiraEra(1, 1, 4);
       assertEquals(true, bissexto.ehBissexto());
    }
    
    @Test
    public void anoNaoEhBissexto() {
        DataTerceiraEra naoBissexto = new DataTerceiraEra(1, 1, 1);
        assertEquals(false, naoBissexto.ehBissexto());
    }
}
