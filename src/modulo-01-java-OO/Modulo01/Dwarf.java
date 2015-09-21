public class Dwarf  {
    protected String nome;
    protected int vida, experiencia;
    protected Status status;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;
        
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
        double numero = this.getNumeroSorte();
        if (numero < 0) {
            this.experiencia += 2;
        }
        else if (numero > 100) {
            int dano = 10, vidaAposFlechada = this.vida - dano;
            if (vidaAposFlechada == 0) {
                this.status = Status.MORTO;
            }
            if (vida > 0) {
                this.vida = vidaAposFlechada;
            }
        }
        if (vida <= 0) {
            this.status = Status.MORTO;
        }
    }
    
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
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