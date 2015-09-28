public class OrcSnaga extends Orc {

    public OrcSnaga() {
        this.vida = 70;
        gerarInventario();
    }
    
    public void gerarInventario() {
         Item arco = new Item("Arco", 1);
         Item flechas = new Item("Flecha", 5);
         this.inventario.adicionarItem(arco);
         this.inventario.adicionarItem(flechas);
    }
}