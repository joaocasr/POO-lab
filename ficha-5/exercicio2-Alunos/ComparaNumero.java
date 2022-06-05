import java.util.Comparator;

public class ComparaNumero implements Comparator<Aluno> {
    public int compare(Aluno a1,Aluno a2){
        return (a1.getNumero().compareTo(a2.getNumero()));
    }
}
