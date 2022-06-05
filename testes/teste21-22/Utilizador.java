import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Utilizador {
    private String numUser;
    private String nomeUser;
    private LocalDate dataAdesao;
    private List<Livro> allLivros;

    public Utilizador(String numUser, String nomeUser, Iterator<Livro> livros){
        this.numUser =numUser;
        this.nomeUser = nomeUser;
        this.allLivros = new ArrayList<>();
        while(livros.hasNext()){
            Livro l = livros.next();
            this.allLivros.add(l.clone());
        }
    }

    public void avancaPags(String codISBN, int n) throws PagInexistenteException{
        Livro l = this.allLivros.stream().map(Livro::clone).filter(x->x.getCodISBN().equals(codISBN)).findFirst().get();
        int i=0;
        while(i<n){
            Pagina p = l.getPagPorLer().get(0);
            if(p==null) throw new PagInexistenteException("Pagina nao existe");
            l.getPagLidas().add(p.clone());
            l.getPagPorLer().remove(0);
            i++;
        }
    }

    public List<Livro> getAllLivros(){
        return this.allLivros.stream().map(Livro::clone).collect(Collectors.toList());
    }

}
