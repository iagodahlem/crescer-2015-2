public class Dwarf  {
    private String nome;
    private int vida, experiencia;
    private Status status;
    
    {
        vida = 110;
        experiencia = 0;
        status = Status.VIVO;
    }
    
    public void Dwarf(String nome) {
        this.nome = nome;
    }
    
    public void receberFlechada() {
        this.vida -= 10;
    }
    
    public int getVida() {
        return this.vida;
    }
}