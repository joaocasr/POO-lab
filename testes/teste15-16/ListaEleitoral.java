import java.util.*;
import java.util.stream.Collectors;

public class ListaEleitoral {
    private String partidoPolitico ;
    private Set<Candidato> eleitos ; // candi datos da lista j´a elei tos
    private List<Candidato> porEleger; // can didatos ainda por eleger


    public ListaEleitoral(String partido, Collection<Candidato> candidatos) {
        this.partidoPolitico = partido;
        this.porEleger = candidatos.stream().map(Candidato::clone).collect(Collectors.toList());
    }

    public Candidato aEleger() throws CandidatosTodosElegidosException,CandidatoJaEleitoException{
        if(this.porEleger.size()==0) throw new CandidatosTodosElegidosException();
        if(!this.eleitos.add(this.porEleger.get(0))) throw new CandidatoJaEleitoException();
        return this.porEleger.get(0).clone();
    }

    public void elege() throws CandidatosTodosElegidosException,CandidatoJaEleitoException{
        if(this.porEleger.size()==0) throw new CandidatosTodosElegidosException();
        if(!this.eleitos.add(this.porEleger.get(0))) throw new CandidatoJaEleitoException();
        Candidato c = this.porEleger.get(0).clone();
        this.eleitos.add(c);
        this.porEleger.remove(0);
    }

    public void elege(int n) throws CandidatosTodosElegidosException{
        if(this.porEleger.size()<n) throw new CandidatosTodosElegidosException();
        int i=0;
        while(i<n){
            try {
                elege();
            }catch (CandidatoJaEleitoException cje){
                System.out.print(cje.getMessage());
            }catch (CandidatosTodosElegidosException cte){
                System.out.print(cte.getMessage());
            }
            i++;
        }
    }

    public Collection<Candidato> candidatos(){
        List<Candidato> allCandidatos = new ArrayList<>();
        this.eleitos.forEach(x->allCandidatos.add(x.clone()));
        this.porEleger.forEach(x->allCandidatos.add(x.clone()));
        return allCandidatos;
    }

    public TreeSet<Candidato> eleitos(){
        Comparator<Candidato> c = (c1,c2)->c1.compareTo(c2);
        return this.eleitos.stream()
                .map(Candidato::clone).collect(Collectors.toCollection(()->new TreeSet<>(c)));
    }

    public TreeSet<Candidato> eleitosIdade(){
        Comparator<Candidato> c = (c1,c2)->
                (c1.getIdade()-c2.getIdade()==0) ? c1.compareTo(c2) : (c1.getIdade()-c2.getIdade());
        return this.eleitos.stream()
                .map(Candidato::clone).collect(Collectors.toCollection(()->new TreeSet<>(c)));
    }

}