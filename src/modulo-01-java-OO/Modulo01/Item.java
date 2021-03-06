public class Item {
    private String descricao;
    private int quantidade;
    
    public Item() {
    }
    
    public Item(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public void aumentarQuantidadeEmMil() {
        this.quantidade += 1000;
    }
    
    public void aumentarQuantidadeComSomatorio() {
        int pa = this.quantidade * (this.quantidade + 1) / 2;
        this.quantidade += 1000 * pa;
    }
    
    public void debitarUmaUnidade() {
        if (this.quantidade > 0) {
            this.quantidade--;
        }
    }

    /*
     * Exercicio de refatoração:
    public void shimbalaie() {
        int pa = this.quantidade * (this.quantidade + 1) / 2;
        this.quantidade = (1000 * pa) + this.quantidade;
    }
    */
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
}