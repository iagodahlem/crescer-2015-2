import java.util.*;

public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {
        ordemDoUltimoAtaque.clear();
        
        ArrayList<Elfo> vivos = new ArrayList<Elfo>();
        for (Elfo vivo : pelotao) {
            if (vivo.getStatus() == Status.VIVO) {
                vivos.add(vivo);
            }
        }
        
        ArrayList<Elfo> verdes = new ArrayList<Elfo>();
        ArrayList<Elfo> noturnos = new ArrayList<Elfo>();
        for (Elfo elfo : vivos) {
            boolean ehElfoVerde = elfo instanceof ElfoVerde;
            if (ehElfoVerde) {
                verdes.add(elfo);
            }
            else {
                noturnos.add(elfo);
            }
        }
        int quantidadeDeVerdes = verdes.size();
        int count = 0;
        
        for (Elfo elfoAtacante : verdes) {
            count++;
            if (quantidadeDeVerdes != count) {
                ordemDoUltimoAtaque.add(elfoAtacante);
                for (Dwarf dwarf : dwarves) {
                    elfoAtacante.atirarFlecha(dwarf);
                }
            }
            if (quantidadeDeVerdes == count) {
                for (Elfo elfoAtacante2 : noturnos) {
                    ordemDoUltimoAtaque.add(elfoAtacante2);
                    for (Dwarf dwarf : dwarves) {
                        elfoAtacante2.atirarFlecha(dwarf);
                    }
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
       return this.ordemDoUltimoAtaque;
    }
}