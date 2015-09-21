import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;
    
    public Inventario() {
        this.itens = new ArrayList<Item>();
    }
    
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
    
    public void perderItem(Item item) {
        this.itens.remove(item);
    }
    
    public Item getItem(int posicao){
        return this.itens.get(posicao);
    }
    
    public int getItensTamanho() {
        return this.itens.size();
    }
    
    public ArrayList<Item> getItens() {
        return itens;
    }
    
    public String getDescricoesItens() {
        String descricao = "";
        int itens = this.getItensTamanho();
        for(int i = 0; i < itens; i++) {
            descricao += this.getItens().get(i).getDescricao();
            if (itens != 1) {
                descricao += "," + "";
            }
        }
        return descricao;  
    }
    
    public Item getItemComMaiorQuantidade() {
        
    }
}   