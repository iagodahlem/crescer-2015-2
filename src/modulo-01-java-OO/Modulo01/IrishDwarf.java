public class IrishDwarf extends Dwarf {
    public IrishDwarf(){
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
    }
   
    public IrishDwarf(String nome) {
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
    
    public void tentarSorte() {
        if (this.getNumeroSorte() == -3333) {
            for(int i = 0; i < this.inventario.getItensTamanho(); i++){
                this.inventario.getItens().get(i).aumentarEmMil2();
            }
        }
    }
}