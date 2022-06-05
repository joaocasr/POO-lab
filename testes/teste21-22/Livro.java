import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Livro implements Comparable<Livro>, Serializable {
    public String codISBN; //código ISBN do livro
    private String nomeLivro;
    private String autor;
    private String editora;
    private List<Pagina> pagLidas; // páginas já lidas
    private List<Pagina> pagPorLer; //páginas ainda por ler.
//o primeiro elemento é a página a ser lida no momento

    public Livro(){}


    /* método que devolve a página com o número indicado */
    public Pagina devolvePag(int numPag) throws PagInexistenteException {
        Pagina res = null;
        int numLidas = this.pagLidas.size(); //número de páginas lidas
        int porLer = this.pagPorLer.size();
        if (numPag > numLidas+porLer)
            throw new PagInexistenteException(numLidas);
        if (numPag <= numLidas )
            res = this.pagLidas.get(numPag -1);
        else
            res = this.pagPorLer.get(numPag-numLidas -1);
        return res.clone();
    }

    public String getCodISBN() {
        return codISBN;
    }

    public void setCodISBN(String codISBN) {
        this.codISBN = codISBN;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public List<Pagina> getPagLidas() {
        return this.pagLidas.stream().map(Pagina::clone).collect(Collectors.toList());
    }

    public void setPagLidas(List<Pagina> pagLidas) {
        this.pagLidas = this.pagLidas.stream().map(Pagina::clone).collect(Collectors.toList());
    }

    public List<Pagina> getPagPorLer() {
        return this.pagPorLer.stream().map(Pagina::clone).collect(Collectors.toList());
    }

    public void setPagPorLer(List<Pagina> pagPorLer) {
        this.pagPorLer = this.pagPorLer.stream().map(Pagina::clone).collect(Collectors.toList());
    }

    public int compareTo(Livro outroLivro){
        return this.getNomeLivro().compareTo(outroLivro.getNomeLivro());
    }

    public Livro clone(){
        return new Livro();
    }
}