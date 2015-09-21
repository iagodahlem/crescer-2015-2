public class Dwarf  {
    private String nome;
    private int vida, experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario;
        
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.vida = 110;
        this.experiencia = 0;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }
    
    public Dwarf(String nome) {
        this(nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public void receberFlechada() {
        this.vida -= 10;
        if (this.vida <= 0) {
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }
    
    public void adicionarItemDwarf(Item item){
        inventario.adicionarItem(item);
    }
    
    public void perderItemDwarf(Item item) {
        inventario.perderItem(item);
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
    
    public int getInventarioDwarf() {
       return inventario.getItensTamanho();
    }
    
    public Inventario getInventario() {
        return this.inventario;
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
    
    public void tentarSorte() {
        if (this.getNumeroSorte() == -3333) {
            for(int i = 0; i < this.inventario.getItensTamanho(); i++){
                this.inventario.getItens().get(i).aumentarQuantidadeEmMil();
            }
        }
    }
}