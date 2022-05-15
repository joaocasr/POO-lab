import java.util.List;
import java.util.stream.Collectors;

public class Aluno {
//...
    public Aluno() {
        //...
    }

   /* public List<Boolean> getEEstatus1(List<Empregado> l) {
        return l.stream().filter(e -> e instanceof Aluno).map(a -> a.epocaEspecial()) --> Empregado não possui uma definicao do metodo epocaEspecial
                .collect(Collectors.toList());
        }*/
    public List<Boolean> getEEstatus2(List<Aluno> l) {
        return l.stream().filter(a -> a instanceof Empregado).map(e -> e.epocaEspecial())
                .collect(Collectors.toList());
    }
    public List<Boolean> getEEstatus3(List<Empregado> l) {
        return l.stream().map(e -> (Aluno) e).map(a -> a.epocaEspecial())
                .collect(Collectors.toList());
    }

    public boolean epocaEspecial() { return false; }
}
