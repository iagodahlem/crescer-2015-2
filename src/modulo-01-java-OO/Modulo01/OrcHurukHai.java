public class OrcHurukHai extends Orc {
    
    public OrcHurukHai() {
        this.vida = 150;
        gerarInventario();
    }
    
    public void gerarInventario() {
        Item escudoUrukHai = new Item("Escudo Uruk-Hai", 1);
        Item espada = new Item("Espada", 1);
        this.inventario.adicionarItem(escudoUrukHai);
        this.inventario.adicionarItem(espada);
    }
}