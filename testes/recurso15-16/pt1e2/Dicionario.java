import java.util.*;
import java.util.stream.Collectors;

public class Dicionario {
    private String nomeDic; //nome do dicionario
    private Map<String,Entrada> entradas; // termo -> definicao

    public Dicionario(String nomeDic){
        this.nomeDic = nomeDic;
        this.entradas = new HashMap<>();
    }

    public void add(Entrada ed) throws ExistingEntryException{
        if(this.entradas.containsKey(ed.getTermo())) throw new ExistingEntryException();
        this.entradas.put(ed.getTermo(),ed.clone());
    }

    public boolean exists(String termo){
        return this.entradas.containsKey(termo);
    }

    public Entrada get(String termo) throws EntryDoesNotExistException{
        if(!exists(termo)) throw new EntryDoesNotExistException();
        return this.entradas.get(termo).clone();
    }

    public Collection<Entrada> getAll(){
        return this.entradas.values();
    }

    public boolean sinonimos(String termo1,String termo2){
        return this.entradas.get(termo1).getDefinicao().equals(this.entradas.get(termo2).getDefinicao());
    }

    public Map<String, List<String>> getSinonimosV1(){
        Map<String, List<String>> m = new HashMap<>();
        for(Entrada e1: this.entradas.values()){
            for(Entrada e2: this.entradas.values()){
                if(!e1.equals(e2)){
                    if(sinonimos(e1.getTermo(),e2.getTermo()) && !m.containsKey(e1.getDefinicao())){
                        List<String> termos = new ArrayList<>();
                        termos.add(e2.getTermo());
                        m.put(e1.getDefinicao(),termos);
                    }
                    if(sinonimos(e1.getTermo(),e2.getTermo()) && m.containsKey(e1.getDefinicao())){
                        m.get(e1.getDefinicao()).add(e2.getTermo());
                    }
                }
            }
        }
        return m;
    }

    /** ALINEA B) */
    public List<String> getSinonimos(String termo){
        return this.entradas.values().stream().map(x->x.clone())
                .filter(x->x.getDefinicao().equals(this.entradas.get(termo).getDefinicao()))
                .map(x->x.getTermo())
                .collect(Collectors.toList());
    }

    public Map<String, List<String>> getSinonimosV2(){
        Map<String,List<String>> m = new HashMap<>();
        this.entradas.values().forEach(x->m.put(x.getDefinicao(),getSinonimos(x.getTermo())));
        //quando é adicionada a mesma chave o valor é atualizado mas neste caso como a lista é igual nao ha problema
        return m;
    }

    /**-------*/

}
