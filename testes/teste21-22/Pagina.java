import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagina implements Comparable<Pagina>, Serializable {
    private List<String> texto;
    public Pagina() {
        this.texto = new ArrayList<>();
    }

    public Pagina(List<String> txt) {
        setTexto(txt);
    }
    /* método que devolve uma formatação do texto */
    public String reproduzPagina() {
        //...
        return "";
        }

    public Pagina clone(){
        return new Pagina();
    }

    public void setTexto(List<String> t){
        this.texto = new ArrayList<>(t);
    }

    @Override
    public int compareTo(Pagina o) {
        return 0;
    }
}