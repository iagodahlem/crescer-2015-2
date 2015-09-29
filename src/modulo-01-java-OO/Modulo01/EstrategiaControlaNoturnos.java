import java.util.*;

public class EstrategiaControlaNoturnos implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {
        ordemDoUltimoAtaque.clear();
        int intencoesDeAtaque = pelotao.size() * dwarves.size();
        int limiteDeElfosNoturno = (int)(intencoesDeAtaque * 0.3);
        int count = 0;
        for (Elfo elfo : pelotao) {
            if (elfo.getStatus() == Status.VIVO) {
                boolean elfoNoturno = elfo instanceof ElfoNoturno;
                if (elfoNoturno) {
                    if (count >= limiteDeElfosNoturno) {
                        continue;
                    }
                    count++;
                }
                ordemDoUltimoAtaque.add(elfo);
                for (Dwarf dwarf : dwarves) {
                    elfo.atirarFlecha(dwarf);
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
       return this.ordemDoUltimoAtaque;
    }
}