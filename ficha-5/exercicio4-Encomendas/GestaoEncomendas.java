import java.util.*;
import java.util.stream.Collectors;

public class GestaoEncomendas {
    private Map<Integer,Encomenda> encomendas;
//int ->tipo primitivo

    public GestaoEncomendas(Map<Integer,Encomenda> allEncomendas){
        setEncomendas(allEncomendas);
    }

    public GestaoEncomendas(GestaoEncomendas g){
        setEncomendas(g.getallEncomendas());
    }


    //estou a copiar o q eu tenho no encomendas na nova hashmap
    public Map<Integer,Encomenda> getallEncomendas(){
       /* HashMap<Integer,Encomenda> new_encomendas = new HashMap<>();
        this.encomendas.forEach((Integer,Encomenda)->new_encomendas.put(Integer,Encomenda.clone()));
        return new_encomendas;*/
        return this.encomendas.entrySet().stream().collect(Collectors.toMap((e)->e.getKey(),
                (e)->e.getValue().clone()));
    }

    public void setEncomendas(Map<Integer,Encomenda> new_encomendas){
        this.encomendas = new HashMap<>();
        new_encomendas.forEach((Integer,Encomenda)->this.encomendas.put(Integer,Encomenda.clone()));
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        GestaoEncomendas gestao = (GestaoEncomendas) o;
        return (this.encomendas.equals(gestao.getallEncomendas()));
    }

    /*
     *  	keySet()::Returns a Set view of the keys contained in this map.
     * */
    public Set<Integer> todosCodigosEnc(){
        return this.encomendas.keySet();
    }

    public void addEncomenda(Encomenda enc){
        if(!this.encomendas.containsValue(enc)) this.encomendas.put(enc.getNencomenda(),enc.clone());
    }

    public Encomenda getEncomenda(Integer cof){
        return this.encomendas.get(cof);
    }

    public void removeEcomenda(Integer cod){
        this.encomendas.remove(cod);
    }


    public Set<Integer> encomendasComProduto(String codProd){
        return this.encomendas.values().stream().filter(p->p.existeProduto(codProd)).map(Encomenda::getNencomenda).collect(Collectors.toSet());
    }


    public Integer encomendaComMaisProdutos(){
        Comparator<Encomenda> c = (e1, e2) -> (e1.numeroTotalProdutos() - e2.numeroTotalProdutos()) * -1;
        return this.encomendas.values().stream().sorted(c).findFirst().orElseThrow().getNencomenda();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Encomenda: ").append(this.encomendas);
        return sb.toString();
    }


    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }

}

