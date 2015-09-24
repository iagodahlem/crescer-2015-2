import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
    private HashMap<Status, ArrayList<Elfo>> porStatus= new HashMap<Status, ArrayList<Elfo>>(); 
    
    public void alistar(Elfo elfo) {
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        exercito.put(elfo.getNome(), elfo);
    }
    
    public Elfo buscarElfoPorNome(String nome) {
        return this.exercito.get(nome);
    }
    
    public void agruparPorStatus() {
        porStatus.clear();
        Status vivo = Status.VIVO;
        Status morto = Status.MORTO;
        for (String nome : exercito.keySet()) {
            Elfo elfo = exercito.get(nome);
            if (elfo.getStatus() == Status.VIVO) {
                porStatus.put(vivo, new ArrayList<Elfo>());
                porStatus.get(vivo).add(elfo);
            }
            else {
                porStatus.put(morto, new ArrayList<Elfo>());
                porStatus.get(morto).add(elfo);
            }
        }
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> values = new ArrayList<Elfo>();
        return values;
    }
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
    
    public int getQuantidadeSoldadosAlistados() {
        return this.exercito.size();
    }
    
    public boolean equals(Object obj) {
        ExercitoDeElfos outroExercito = (ExercitoDeElfos)obj;
        return this.exercito == outroExercito.getExercito();
    }
}