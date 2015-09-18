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
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        if (this.vida == 0) {
            this.status = Status.MORTO;
        }
        return this.status;
    }
    
    public DataTerceiraEra getDataDeNascimento() {
        return this.dataNascimento;
    }
}