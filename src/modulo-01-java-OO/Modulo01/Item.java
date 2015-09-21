public class Item {
    private String descricao;
    private int quantidade;
    
    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public Item() {

    }
    
    public void aumentarQuantidadeEmMil() {
        this.quantidade += 1000;
    }
    
    public void aumentarEmMil2() {
        int incremento = 0;
        for (int i = 0; i <= quantidade; i++) {   
            incremento += i;
        }
        this.quantidade = incremento * 1000 + this.quantidade;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
}