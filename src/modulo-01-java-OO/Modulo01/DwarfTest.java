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
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }

    @Test
    public void dwarfNasceVivo() {
        Dwarf balin = new Dwarf();
        assertEquals(Status.VIVO, balin.getStatus());
    }

    @Test
    public void dwarfNasceCom0DeExperiencia() {
        Dwarf balin = new Dwarf();
        assertEquals(0, balin.getExperiencia());
    }

    @Test
    public void dwarfNasceComDataNascimentoPadrão() {
        Dwarf bofur = new Dwarf();
        DataTerceiraEra esperada = new DataTerceiraEra(1,1,1);
        DataTerceiraEra obtida = bofur.getDataDeNascimento();
        assertEquals(esperada, obtida);
    }

    @Test
    public void dwarfNasceComNomeEDataDeNascimento() {
        DataTerceiraEra esperada = new DataTerceiraEra(12,11,1987);
        Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(12, 11, 1987));
        assertEquals(esperada, bernardin.getDataDeNascimento());
        assertEquals("Bernardin", bernardin.getNome());
    }

    @Test
    public void dwarfNasceComNome() {
        Dwarf oin = new Dwarf("Oin II");
        assertEquals("Oin II", oin.getNome());
    }

    @Test
    public void dwarfRecebeFlechaEPerde10Vida() {
        // AAA
        // Arrange
        Dwarf gimli = new Dwarf();
        int vidaEsperada = 100;
        // Act
        gimli.receberFlechada();
        // Assert
        assertEquals(vidaEsperada, gimli.getVida());
    }

    @Test
    public void dwarfRecebeFlecha5VezesESobrevive() {
        Dwarf gimli = new Dwarf();
        // Act
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        gimli.receberFlechada();
        // Assert
        assertEquals(Status.VIVO, gimli.getStatus());
    }

    @Test
    public void gerarNumeroAnoBissextoVidaEntre80e90() {
        // Arrange
        Dwarf uru = new Dwarf("Uru", new DataTerceiraEra(01, 01, 2016));
        uru.receberFlechada();
        uru.receberFlechada();
        uru.receberFlechada();
        // Act
        double resultado = uru.getNumeroSorte();
        // Assert
        assertEquals(-3333.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroAnoNaoBissextoNomeSeixas() {
        // Arrange
        Dwarf seixas = new Dwarf("Seixas", new DataTerceiraEra(01, 01, 2015));
        // Act
        double resultado = seixas.getNumeroSorte();
        // Assert
        assertEquals(33.0, resultado, 0.00001);
    }

    @Test
    public void gerarNumeroSemEntrarNasCondicoes() {
        // Arrange
        Dwarf balin = new Dwarf();
        // Act
        double resultado = balin.getNumeroSorte();
        // Assert
        assertEquals(101.0, resultado, 0.00001);
    }

    @Test
    public void dwarfReceberFlechadaComAnoNormalMeireles() {
        Dwarf meireles = new Dwarf("Meireles", new DataTerceiraEra(2, 3, 2015));
        meireles.receberFlechada();
        assertEquals(0, meireles.getExperiencia());
        assertEquals(110, meireles.getVida());
    }

    @Test
    public void dwarfReceberFlechadaNormal(){
        Dwarf dwarf = new Dwarf();
        dwarf.receberFlechada();
        assertEquals(100, dwarf.getVida());
        assertEquals(0, dwarf.getExperiencia());
    }

    @Test
    public void dwarfTentarSorteComSorte() {
        Dwarf dwarf = new Dwarf("Leprechaun sortudo", new DataTerceiraEra(1, 1, 2000));
        dwarf.receberFlechada();
        dwarf.receberFlechada();
        dwarf.adicionarItem(new Item("Lança", 5));
        dwarf.adicionarItem(new Item("Poção", 25));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Lança", 1005));
        esperado.adicionarItem(new Item("Poção", 1025));
        
        dwarf.tentarSorte();
        
        assertEquals(esperado, dwarf.getInventario());
    }

    @Test
    public void dwarfTentarSorteSemSorte() {
        Dwarf dwarf = new Dwarf();
        dwarf.adicionarItem(new Item("Lança", 5));
        dwarf.adicionarItem(new Item("Poção", 25));
        
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Lança", 5));
        esperado.adicionarItem(new Item("Poção", 25));
        
        dwarf.tentarSorte();
        
        assertEquals(esperado, dwarf.getInventario());
    }
}