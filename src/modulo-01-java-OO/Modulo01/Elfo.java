public class Elfo {
    private String nome;
    private int flechas = 42;
    private int experiencia = 0;
    
    public Elfo(String n) {
        nome = n;
    }
    
    public void atirarFlecha(String alvo) {
        flechas--;
        experiencia++;
    }
    
    public void atirarFlechaRefactory(String alvo) {

    }
}