import java.util.*;

public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<String, Elfo>();
    private HashMap<Status, ArrayList<Elfo>> porStatus= new HashMap<Status, ArrayList<Elfo>>(); 
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
    public void alistar(Elfo elfo) {
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if (podeAlistar) {
            this.exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public Elfo buscarElfoPorNome(String nome) {
        return this.exercito.get(nome);
    }
    
    public void agruparPorStatus() {
        porStatus.clear();
        for (Map.Entry<String, Elfo> parChaveValor : this.exercito.entrySet()) {    
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            if (!porStatus.containsKey(status)) {
                porStatus.put(status, new ArrayList<Elfo>(Arrays.asList(elfo)));
            } else {
                porStatus.get(status).add(elfo);
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