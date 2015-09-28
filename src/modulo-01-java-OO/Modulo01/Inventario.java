import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens = new ArrayList<Item>();
    
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
    
    public void perderItem(Item item) {
        this.itens.remove(item);
    }
    
    public ArrayList<Item> getItens() {
        return this.itens;
    }
    
    public String getDescricoesItens() {
        String descricao = "";
        for (Item item : this.itens) {
            descricao += item.getDescricao();
        }
        return descricao.substring(0, descricao.length() - 1);
    }
    
    public Item getItemPorDescricao(String descricao) {
        for (Item item : this.itens) {
            if (item.getDescricao().equals(descricao)) {
                return item;
            }
        }
        
        return null;
    }
    
    public Item getItemComMaiorQuantidade() {
        int indice = 0, maiorQtd = 0;
        for (Item item : this.itens) {
            int qtdAtual = item.getQuantidade();
            if (qtdAtual > maiorQtd) {
                indice = this.itens.indexOf(item);
                maiorQtd = qtdAtual;
            }
        }
        return this.itens.get(indice);
    }
    
    public void ordenarItens() {    
        // Versão mais simples porém mais instável do BubbleSort - sempre O(n^2)
        int numeroItens = this.itens.size();
        
        for (int i = 0; i < numeroItens; i++) {
            for (int j = 0; j < numeroItens - 1; j++) {
                Item itemAtual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                }
            }
        }
    }
    
    public void aumentarQuantidadeEmMil() {
        for (Item item : this.itens) {
            item.aumentarQuantidadeEmMil();
        }
    }
    
    public void aumentarQuantidadeComSomatorio() {
        for (Item item : this.itens) {
            item.aumentarQuantidadeComSomatorio();
        }
    }
    
    public boolean equals(Object obj) {
        Inventario outroInventario = (Inventario)obj;
        return this.itens.equals(outroInventario.getItens());
    }
}   