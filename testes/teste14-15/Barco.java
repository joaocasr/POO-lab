import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.Serializable;

public abstract class Barco implements Serializable{
    private String id;
    private double milhas;
    private String categoria;
    private double autonomia;
    private Pessoa skipper;
    private Set<Pessoa> tripulantes;
    private List<RegistoEtapa> allRegistos;


    public Barco(Barco b){
        this.id=b.getId();
        this.milhas =b.getMilhas();
        this.categoria = b.getCategoria();
        this.autonomia = b.getAutonomia();
        this.skipper =  b.getSkipper();
        setTripulantes(b.getTripulantes());
        setAllRegistos(b.getAllRegistos());
    }


    public List<RegistoEtapa> getAllRegistos(){
        return this.allRegistos.stream().map(x->x.clone()).collect(Collectors.toList());
    }
    public void setAllRegistos(List<RegistoEtapa> l){
        this.allRegistos = l.stream().map(x->x.clone()).collect(Collectors.toList());
    }

    public Set<Pessoa> getTripulantes(){
        Set<Pessoa> aux = new HashSet<>();
        this.tripulantes.forEach(x->aux.add(x.clone()));
        return aux;
    }

    public void setTripulantes(Set<Pessoa> l){
        this.tripulantes = new HashSet<>();
        l.forEach(x->this.tripulantes.add(x.clone()));
    }

    public void getTripulantes(Set<Pessoa> s){
        this.tripulantes = new HashSet<>();
        s.forEach(x->this.tripulantes.add(x.clone()));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMilhas() {
        return milhas;
    }

    public void setMilhas(double milhas) {
        this.milhas = milhas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }

    public Pessoa getSkipper() {
        return skipper;
    }

    public void setSkipper(Pessoa skipper) {
        this.skipper = skipper;
    }

    public Barco clone(){return(this);}
}
