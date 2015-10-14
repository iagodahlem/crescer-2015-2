public class Elfo extends Personagem {
    private int flechas;
    private static int contador;
    
    /**
     * Type Initializer
     * executa antes de cada construtor
     * {
     *     flechas = 42;
     * }
     */
    
    public Elfo(String nome) {
        this(nome, 42);
    }
    
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
        this.vida = 100;
        this.experiencia = 0;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
        this.contador ++;
    }
    
    /* Método para demonstrar implementação com int Integer X
    public Elfo(String nome, Integer flechas) {
        this(nome);
        if (flechas != null) {
            this.flechas = flechas;
        }
    }
    */

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
    
    public void atacarOrc(Orc orc) {
        orc.levarAtaqueDeElfo();
    }
    
    public int getFlechas() {
        return this.flechas;
    }

    public static int getContador() {
        return contador;
    }
    
    public static void resetaContador() {
        contador = 0;
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
   
    // String de forma errada
    /*
     * public String toString() {
     *     return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " niveis de experiencia.";
     *  }
     */
  
    // String de forma correta
    public String toString() {
        
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;
        
        // Ruby ou CoffeeScript:
        //"#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."
        
        // C# 6:
        //"\{nome} possui \{flechas} \{textoFlechas} e \{experiencia} \{textoNiveis} de experiência."
        
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, flechaNoSingular ? "flecha" : "flechas", this.experiencia, nivelNoSingular ? "nível" : "níveis");
    }
}