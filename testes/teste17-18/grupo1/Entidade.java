import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Entidade {
    private String nif;
    private String name;
    private Map<LocalDate,Fatura> faturas;


    public String getNif(){
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<LocalDate, Fatura> getFaturas() {
        return this.faturas.entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(),e-> e.getValue().clone()));
    }

    public void setFaturas(Map<LocalDate, Fatura> faturas) {
        this.faturas = new HashMap<>();
        faturas.forEach((key,value)->this.faturas.put(key,value.clone()));
    }

    public Map<Actividade, List<Fatura>> porActividade(){
        return this.faturas.values().stream().map(Fatura::clone)
                                        .collect(Collectors
                                            .groupingBy(Fatura::getActividade,toList()));
    }

}
