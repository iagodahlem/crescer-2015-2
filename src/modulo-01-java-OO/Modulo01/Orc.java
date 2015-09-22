public class Orc extends Personagem{

    public Orc(String nome) { 
        this.nome = nome;
    }
        
    public void receberFlechaDeElfo(Elfo elfo) {
        this.vida -= 8;
    }
    
    public void receberFlechaDeAnao(Dwarf dwarf) {

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
}