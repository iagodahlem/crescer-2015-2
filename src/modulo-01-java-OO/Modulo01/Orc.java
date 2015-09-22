public class Orc {
    private String nome;
    private int vida;
    private Inventario inventario = new Inventario();
    
    protected Item arco;
    protected Item flecha;
    protected Item espada;
    protected Item escudoUrukHai;

    public Orc(String nome) { 
        this.nome = nome;
        if (this.nome == "Uruk-Hai") {
            inventario.adicionarItem(escudoUrukHai);
            inventario.adicionarItem(espada);           
            this.vida = 150;
        }
        if (this.nome == "Snaga") {
            inventario.adicionarItem(arco);
            inventario.adicionarItem(flecha);
            this.vida = 70;
        }
        if (this.nome != "Uruk-Hai" || this.nome != "Snaga") {
            
        }
    }
        
    public void receberFlechaDeElfo(Elfo elfo) {
        this.vida -= 8;
    }
    
    public void receberFlechaDeAnao(Dwarf dwarf) {
        if (this.escudoUrukHai == null) {
            this.vida -= 10;
        }
        this.vida -= 5;
    }
    
    /*
    public void atacarDwarf(Dwarf dwarf) {
        dwarf.vida -= 10;
        
        for (Item item : this) {
            ArrayList<int> numeroDeFlechas = new ArrayList<int>();
            numeroDeFlechas.add(1);
            numeroDeFlechas.add(2);
            numeroDeFlechas.add(3);
            
            for (int i = 0; i < 3; i++) {
                
                if (item.getDescricao() == "Flecha" + i) {
                    this.novosItens.remove(item);
                }
            }
        }
    }
    
    public void atacarElfo(Elfo elfo) {
        
    }
    */
    
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
}