public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    @Override
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia += 2;
        double percentual = this. vida * 0.05;
        this.vida -= percentual;
        this.status = (int)this.vida == 0 ? Status.MORTO : this.status;
    }
}