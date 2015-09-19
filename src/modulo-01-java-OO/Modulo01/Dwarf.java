public class Dwarf  {
    private String nome;
    private int vida, experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    
    {
        vida = 110;
        experiencia = 0;
        status = Status.VIVO;
    }
    
    public Dwarf(String nome) {
        this(nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void receberFlechada() {
        this.vida -= 10;
        if (this.vida <= 0) {
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public DataTerceiraEra getDataDeNascimento() {
        return this.dataNascimento;
    }
    
    public double getNumeroSorte() {
        double numeroSorte = 101.0;
        if (this.dataNascimento.ehBissexto() == true && this.vida >=80 || this.vida <=90) {
            numeroSorte *= -33;
        }
        if (!dataNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) {
           numeroSorte = numeroSorte * 33 % 100;
        }      
        return numeroSorte;
    }
}