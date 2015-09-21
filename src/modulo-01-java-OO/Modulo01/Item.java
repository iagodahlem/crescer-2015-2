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
        int pa = this.quantidade * (this.quantidade + 1) / 2;
        this.quantidade += (1000 * pa);
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
}