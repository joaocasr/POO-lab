import java.util.*;
import java.util.stream.Collectors;

public class Grafo {
// variáveis de instância
private Map<Integer, Set<Integer>> adj ;
// " lista " de adjacência

    public Grafo(){
       this.adj = new HashMap<>();
    }

    public Grafo(Map<Integer, Set<Integer>> m){
        setGrafo(m);
    }

    public void addArco(Integer vOrig, Integer vDest){
        if(this.adj.containsKey(vOrig)) this.adj.get(vOrig).add(vDest);
        else{
            Set<Integer> s= new HashSet<>();
            s.add(vDest);
            this.adj.put(vOrig,s);
        }
    }

    public boolean isSink(Integer v){
        boolean isSink=false;
        if(adj.get(v).size()==0) isSink=true;
        return isSink;
    }

    public boolean isSource(Integer v){
        return this.adj.keySet().stream().anyMatch(x->x.equals(v));//existe no stream um elemento v?
    }

    public int size(){
        int vertices = (int) this.adj.keySet().stream().count();
        int arestas = this.adj.values().stream().mapToInt(x->x.size()).sum();
        return vertices+arestas;
    }

    public Map<Integer, Set<Integer>> getGrafo(){
       return this.adj.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public boolean haCaminho(Integer vOrig, Integer vDest){
        if(vOrig.equals(vDest)) return true;
        for(Integer i: this.adj.get(vOrig)){
            haCaminho(i,vDest);
        }
        return false;
    }

    public void setGrafo(Map<Integer, Set<Integer>> m){
        this.adj = new HashMap<>();
        m.forEach((key,value)->this.adj.put(key,value));
    }

}
