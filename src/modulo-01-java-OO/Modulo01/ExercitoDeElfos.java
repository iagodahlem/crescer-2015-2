import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
    
    public void alistar(ElfoVerde elfo) {
        exercito.put(elfo.getNome(), elfo);
    }
    
    public void alistar(ElfoNoturno elfo) {
        exercito.put(elfo.getNome(), elfo);
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