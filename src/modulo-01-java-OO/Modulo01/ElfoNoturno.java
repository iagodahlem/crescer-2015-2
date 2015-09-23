public class ElfoNoturno extends Elfo {
    int flechas;
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
    }
    
    @Override
    public void atirarFlecha(Dwarf dwarf) {
        double percentual = this. vida * 0.05;
        super.atirarFlecha(dwarf);
        this.experiencia ++;
        this.experiencia ++;
        this.vida -= percentual;
    }
}