import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cliente implements Serializable {
    private String nome;
    private String codCliente;
    private Map<LocalDate, List<Exercicio>> meusExercicios;

    public Map<LocalDate,List<Exercicio>> getMeusExercicios(){
        Map<LocalDate, List<Exercicio>> aux = new HashMap<>();
        for(LocalDate d : this.meusExercicios.keySet()){
            List<Exercicio> l = this.meusExercicios.get(d).stream().map(Exercicio::clone).collect(Collectors.toList());
            aux.put(d,l);
        }
        return aux;
    }

    public Map<String,List<Exercicio>> exerciciosPorProf(){
        return this.meusExercicios.values().stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(Exercicio::getProfessor,
                        HashMap::new,Collectors.mapping(Exercicio::clone,Collectors.toList())));
    }
}
