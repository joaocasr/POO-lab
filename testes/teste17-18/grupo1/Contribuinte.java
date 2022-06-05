import java.util.List;
import java.util.stream.Collectors;

public class Contribuinte extends Entidade{
    private List<Contribuinte> dependentes;

    public Contribuinte(){}

    public Contribuinte(Contribuinte c){
        setDependentes(c.getDependentes());
    }

    private List<Contribuinte> getDependentes(){
        return this.dependentes.stream().map(Contribuinte::clone)
                .collect(Collectors.toList());
    }

    private void setDependentes(List<Contribuinte> l){
        this.dependentes = l.stream().map(Contribuinte::clone)
                .collect(Collectors.toList());
    }

    public Contribuinte clone(){
        return new Contribuinte(this);
    }
}
