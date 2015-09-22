public class Orc {
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public int VIDA;
    
    protected Item Arco;
    protected Item Flecha1;
    protected Item Flecha2;
    protected Item Flecha3;
    protected Item EscudoUrukHai;

    /**
     * COnstrutor para objetos da classe orc
     */
    public orc()
    {
        VIDA = 100 / 10 * 2.5;
    }

    public void gerarVida(int vidaAleatoria) {
        VIDA = vidaAleatoria;
    }
    
    public void Recever_Flecha_De_Elfo(Elfo elfo) {
        
        if(this.EscudoUrukHai == null) {
            gerarVida(this.VIDA - 10);
        }
        
        gerarVida(this.Vida - 5);
    }
    
    public void Recever_Flecha_De_Anao(Dwarf elfo) {
        if(this.EscudoUrukHai == null) {
            gerarVida(this.VIDA - 10);
        }
        
        gerarVida(this.Vida - 5);
    }
    
    public void adicionarNovoItem(Item i) {
        
        if(i.getDescricao() == "Escudo UrukHai") {
            this.EscudoUrukHai = i;
        }
        else if(i.getDescricao().indexOf("Flecha") >= 0) {
            
            if(i.getDescricao() == "Flecha1")
                this.Flecha1 = i;
            if(i.getDescricao() == "Flecha2")
                this.Flecha2 = i;
            if(i.getDescricao() == "Flecha3")
                this.Flecha3 = i;
            else
                this.Arco = new Item(1, "Arco  Uruk Hay");
                this.Flecha1 = new Item(1, "Flecha");
        }
        else {
            this.Arco = i;
        }
        
    }
    
    public void AtacarAnao(Dwarf anao) {
    
        anao.vida -= 10;
        
        for (Item item : this.novosItens) {
            
            ArrayList<int> numeroDeFlechas = new ArrayList<int>();
            numeroDeFlechas.add(1);
            numeroDeFlechas.add(2);
            numeroDeFlechas.add(3);
            
            for(int i = 0; i++; i <= 3) {
                
                if(item.getDescricao() == "Flecha" + i) {
                    this.novosItens.remove(item);
                }
            }
        }
    }
}