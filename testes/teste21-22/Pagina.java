import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagina implements Comparable<Pagina>, Serializable {
    private List<String> texto;
    public Pagina() {
        this.texto = new ArrayList<>();
    }
    /* método que devolve uma formatação do texto */
    public String reproduzPagina() {
        //...
        return "";
        }

    public Pagina clone(){
        return new Pagina();
    }

    @Override
    public int compareTo(Pagina o) {
        return 0;
    }
}