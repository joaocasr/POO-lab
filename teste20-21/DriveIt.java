import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DriveIt {
    private Map<String, Veiculo> viaturas;


    public Set<Veiculo> veiculosDaMarca(String marca){
        TreeSet<Veiculo> r = new TreeSet<>((v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula()));
        for (Veiculo v : this.viaturas.values()) {
            if (v.getMarca().equals(marca)) r.add(v.clone());
        }
        return r;
    }



}
