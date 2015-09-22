public class IrishDwarf extends Dwarf {
    
    public IrishDwarf(){
    }
    
    public IrishDwarf(String nome) {
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
    }
      
    public void tentarSorte() {
        double numeroSorte = getNumeroSorte();
        if (numeroSorte == -3333.0) {
            this.inventario.aumentarQuantidadeComSomatorio();
        }
    }
}