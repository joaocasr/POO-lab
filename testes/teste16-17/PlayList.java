import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PlayList {
    private String nome;
    private Map<String, List<Faixa>> musicas;


    public List<Faixa> getFaixas(String autor)
                throws AutorInexistenteException{
        if(!this.musicas.containsKey(autor)) throw new AutorInexistenteException("Autor "+autor+" não existe.");
        else return this.musicas.get(autor).stream().map(Faixa::clone).collect(toList());

    }

    public double tempoTotal(String autor) throws AutorInexistenteException{
        if(!this.musicas.containsKey(autor)) throw new AutorInexistenteException("Artista "+autor+" não existe.");
        else return this.musicas.get(autor).stream().mapToDouble(x->x.getDuracao()).sum();
    }

    public List<Faixa> todasAsFaixas(){
        return this.musicas.values().stream().flatMap(List::stream).map(Faixa::clone).collect(toList());
    }

    public Map<Integer,List<Faixa>> faixasPorClass(){
        return todasAsFaixas().stream().collect(Collectors.groupingBy(Faixa::getClassificacao,toList()));
    }

    /**
     * Métodos getters e setters
     *
     * */
    public Map<String,List<Faixa>> getAllMusicas(){
        Map<String,List<Faixa>> m = new HashMap<>();
        for(String autor: this.musicas.keySet()){
            List<Faixa> l =this.musicas.get(autor).stream().map(Faixa::clone).collect(toList());
            m.put(autor,l);
        }
        return m;
    }

    public void setAllMusicas(Map<String,List<Faixa>> m){
        this.musicas = new HashMap<>();
        for(String autor: m.keySet()){
            List<Faixa> l =m.get(autor).stream().map(Faixa::clone).collect(toList());
            this.musicas.put(autor,l);
        }
    }
}