import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LivrosDigitais {
    private Map<String,Utilizador> allUsers;
    private Map<String,Livro> allLivros;


    public Livro livroMaisLido(){
        Map<String,List<Livro>> m =this.allUsers.values().stream()
                .map(Utilizador::getAllLivros)
                .flatMap(List::stream)
                .filter(x->x.getPagPorLer().size()==0)
                .collect(Collectors.groupingBy(Livro::getNomeLivro,toList()));
        int max=0;
        String maisLido="";
        for(String l : m.keySet()){
            if(max<m.get(l).size()){
                max =m.get(l).size();
                maisLido=l;
            }
            if(max==m.get(l).size()){
                maisLido = (l.compareTo(maisLido)>0) ? maisLido:l;
            }
        }
        return allLivros.get(maisLido).clone();
    }

    public Map<String,List<Livro>> livrosPorEditora(){
       return this.allLivros.values().stream().map(Livro::clone).collect(Collectors.groupingBy(Livro::getEditora,toList()));
    }
}
