import java.util.*;
import java.util.stream.Collectors;

public class Equipa {
    private String nome;
    private Map<String,Barco> barcos;

    public Equipa(){}


    public double totalEmProva(String idBarco){
        return this.barcos.get(idBarco).getAllRegistos()
                .stream().mapToDouble(x->x.getFim().getTimeInMillis()-x.getInicio().getTimeInMillis())
                .sum();
    }

    public double registoMaisLongo(){
        Comparator<RegistoEtapa> c =(c1,c2)->(int) (c2.getFim().getTimeInMillis()-c1.getInicio().getTimeInMillis());
        RegistoEtapa r = this.barcos.values().stream().map(Barco::getAllRegistos)
                    .flatMap(List::stream)
                    .sorted(c)
                    .findFirst()
                    .get().clone();
        return r.getFim().getTimeInMillis()-r.getInicio().getTimeInMillis();
    }


    public Set<Barco> ordenaBarcos(){
        return this.barcos.values().stream()
                .map(Barco::clone)
                .filter(x-> x instanceof BarcoCatamaran || x instanceof BarcoHibrido)
                .collect(Collectors.toCollection(()->new TreeSet<>(new ComparaSeguro())));

    }

    public Map<String,Barco> getAllBarcos(){
        return this.barcos.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void setAllBarcos(Map<String,Barco> m){
        this.barcos = m.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,e->e.getValue().clone()));
    }

    public Equipa clone(){
        return new Equipa();
    }
}
