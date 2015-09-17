/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas, experiencia;
    
    /**
     * Type Initializer
     * executa antes de cada construtor
     * {
     *     flechas = 42;
     * }
     */
    
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
    }
    
    /* Método para demonstrar implementação com int Integer X
    public Elfo(String nome, Integer flechas) {
        this(nome);
        if (flechas != null) {
            this.flechas = flechas;
        }
    }
    */
    
    public Elfo(String nome) {
        this(nome, 42);
    }

    /* Exemplos de nomenclatura
     * 
     * PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
    */
   
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia++;
        dwarf.receberFlechada();
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }

    /* Refatoraçao Antes:
      
    public atirarFlechaRefactory(this.flechas, this.experiencia){
        if(boolean acertar == true){
            flechas--;
            experiencia++;
        }else{
             flechas--;
        }
    }
    
    Depois:
    public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
    */
    
    public String getNome() {
        return this.nome;
    }
    
    /* Exemplo de setter
     * 
    public void setNome(String novoNome) {
        this.nome = novoNome;
    }
    */
    
    public int getFlechas() {
        return this.flechas;
    }
    
    /*Exemplo de setter
     * 
    public void setFlechas(int flechas) {
        if (flechas > this.flechas)
        this.flechas = flechas;
     }
    */
   
   public int getExperiencia() {
       return this.experiencia;
   }
   
   public String toString() {
       return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " niveis de experiencia.";
   }
}
