public class Dwarf extends Personagem {
    
    public Dwarf() {
        this.vida = 110;
        this.experiencia = 0;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
        this.inventario = new Inventario();
    }
    
    public Dwarf(String nome) {
        this();
        this.nome = nome;
    }
   
    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
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
        double numeroSorte = getNumeroSorte();
        if (numeroSorte == -3333.0) {
            this.inventario.aumentarQuantidadeEmMil();
        }
    }
}