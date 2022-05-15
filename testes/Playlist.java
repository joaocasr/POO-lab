import java.util.*;
import java.util.stream.Collectors;

public class Playlist {
    private String nome;
    private Map<String, List<Faixa>> musicas;

    public Playlist(){

    }

    public List<Faixa> getFaixas(String autor) throws AutorInexistenteException{
        List<Faixa> lista = musicas.get(autor);
        if(lista==null) throw new AutorInexistenteException("O autor "+autor+" não existe.");
        return lista;
    }

    public double tempoTotal(String autor) throws AutorInexistenteException{
        double total=0;
        if(this.musicas.get(autor)==null) throw new AutorInexistenteException("O autor "+autor+" não exise.");
        else{
            total =this.musicas.get(autor).stream().mapToDouble(Faixa::getDuracao).sum();
        }
        return total;
    }

    //externos: iterator
    //internos stream / foreach
    public List<Faixa> todasAsFaixas(){ //converter lista de listas numa só lista
        List<Faixa> lista = new ArrayList<>();
        lista = this.musicas.values().stream().flatMap(List::stream).collect(Collectors.toList());
        return lista;
    }

    public Map<Integer,List<Faixa>> faixasporClass(){
        return this.musicas.values().stream().flatMap(List::stream).collect(Collectors.groupingBy(Faixa::getClassificacao));
    }

    public Playlist clone(){
        return new Playlist();
    }


}
